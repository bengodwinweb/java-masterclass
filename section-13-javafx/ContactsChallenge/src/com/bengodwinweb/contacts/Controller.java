package com.bengodwinweb.contacts;

import com.bengodwinweb.contacts.datamodel.Contact;
import com.bengodwinweb.contacts.datamodel.ContactData;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Predicate;

public class Controller {
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private Label topLabel;
    @FXML
    private TableView<Contact> contactTableView;
    @FXML
    private TextField searchBar;

    @FXML
    private ContextMenu tableContextMenu;
    private FilteredList<Contact> filteredList;

    public enum Action {
        EDIT, NEW
    }

    public void initialize() {

        tableContextMenu = new ContextMenu();
        MenuItem newMenuItem = new MenuItem("New");
        newMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                newContactDialog();
            }
        });
        MenuItem editMenuItem = new MenuItem("Edit");
        editMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                editContactDialog();
            }
        });
        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                deleteContact();
            }
        });

        tableContextMenu.getItems().addAll(newMenuItem, editMenuItem, deleteMenuItem);
        contactTableView.setContextMenu(tableContextMenu);

        // filter the list of contacts from ContactData by predicate
        filteredList = new FilteredList<Contact>(ContactData.getInstance().getContacts());

        searchBar.textProperty().addListener((obsservable, oldValue, newValue) -> {
            filteredList.setPredicate(contact -> {
                if (newValue == null) {
                    return true;
                }

                String searchTerm = newValue.trim().toLowerCase();
                String phoneNumberSearchTerm = Contact.sanitizePhoneNumber(searchTerm);

                // return true if searchTerm is part of last name
                if (contact.getLastName().toLowerCase().contains(searchTerm)) {
                    return true;
                }
                // return true if searchTerm is part of first name
                if (contact.getFirstName().toLowerCase().contains(searchTerm)) {
                    return true;
                }
                // return true if searchTerm is in notes
                if (contact.getNotes().toLowerCase().contains(searchTerm)) {
                    return true;
                }
                // return true is searchTerm is exactly "(" - beginning of a phone number
                if (searchTerm.equals("(")) {
                    return true;
                }
                // return true is searchTerm is in phoneNumber and phoneNumberSearchTerm.length() is positive
                if (phoneNumberSearchTerm.length() > 0
                        && contact.getRawPhoneNumber().contains(phoneNumberSearchTerm)) {
                    return true;
                }

                // no match, return false
                return false;
            });
        });

        SortedList<Contact> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(contactTableView.comparatorProperty());

        // Last Name Column
        TableColumn<Contact, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastNameColumn.setMinWidth(100);
        lastNameColumn.setMaxWidth(125);
        // First Name Column
        TableColumn<Contact, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstNameColumn.setMinWidth(100);
        firstNameColumn.setMaxWidth(125);
        // Phone Number Column
        TableColumn<Contact, String> phoneNumberColumn = new TableColumn<>("Phone Number");
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        phoneNumberColumn.setMinWidth(125);
        phoneNumberColumn.setMaxWidth(125);
        phoneNumberColumn.setStyle("-fx-alignment: CENTER;");
        // Notes Column
        TableColumn<Contact, String> notesColumn = new TableColumn<>("Notes");
        notesColumn.setCellValueFactory(new PropertyValueFactory<>("notes"));

        // Add Columns to table view
        contactTableView.getColumns().setAll(firstNameColumn, lastNameColumn, phoneNumberColumn, notesColumn);

        // Placeholder if no contacts
        contactTableView.setPlaceholder(new Label("No contacts to display"));

        contactTableView.setItems(sortedList);
        contactTableView.getSelectionModel().selectFirst();
        contactTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        contactTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        contactTableView.getSortOrder().add(lastNameColumn);
        contactTableView.getSortOrder().add(firstNameColumn);
        contactTableView.sort();
    }

    @FXML
    public void editContactDialog() {
        contactDialog(Action.EDIT);
    }

    @FXML
    public void newContactDialog() {
        contactDialog(Action.NEW);
    }

    @FXML
    private void contactDialog(Action action) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());

        String dialogTitle;
        String dialogHeader;
        // only used if editing
        Contact selected = contactTableView.getSelectionModel().getSelectedItem();

        if (action == Action.EDIT) {
            dialogTitle = "Edit Contact";
            dialogHeader = "Edit Contact: " + selected.getFirstName() + " " + selected.getLastName();
        } else {
            dialogTitle = "Add New Contact";
            dialogHeader = "Use this dialog to create a new Contact";
        }

        dialog.setTitle(dialogTitle);
        dialog.setHeaderText(dialogHeader);
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("contactDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch(IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        ContactDialogController controller = fxmlLoader.getController();
        if (action == Action.EDIT) {
            // if editing, set the text in the form using selected contact
            controller.setContact(selected);
        }

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // new Contact generated by form data
            Contact contact = controller.getContact();
            if (action == Action.NEW) {
                // add Contact to data
                ContactData.getInstance().addContact(contact);
            }
            if (action == Action.EDIT) {
                // replace object selected in tableView with new contact from form
                Collections.replaceAll(ContactData.getInstance().getContacts(), selected, contact);
            }
            ContactData.getInstance().saveContacts();
            contactTableView.getSelectionModel().select(contact);
        }
        // Cancel pressed - do nothing
    }

    @FXML
    public void deleteContact() {
        Contact contact = contactTableView.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Delete Contact");
        alert.setHeaderText("Delete Contact: " + contact.getFirstName() + " " + contact.getLastName());
        alert.setContentText("Are you sure you'd like to delete this contact?\n" +
                "Press OK to confirm or Cancel to exit");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            ContactData.getInstance().deleteContact(contact);
            ContactData.getInstance().saveContacts();
        }
    }

    @FXML
    public void handleKeyPressed(KeyEvent e) {
        Contact selected = contactTableView.getSelectionModel().getSelectedItem();

        if (selected != null) {
            KeyCode keyCode = e.getCode();
            switch (keyCode) {
                case BACK_SPACE:
                    deleteContact();
                    break;
                case N:
                    newContactDialog();
                    break;
                case E:
                    editContactDialog();
                    break;
                default:
                    break;
            }
        }
    }

}
