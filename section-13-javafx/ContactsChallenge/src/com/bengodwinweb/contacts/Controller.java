package com.bengodwinweb.contacts;

import com.bengodwinweb.contacts.datamodel.Contact;
import com.bengodwinweb.contacts.datamodel.ContactData;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.ArrayList;
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

    private FilteredList<Contact> filteredList;
    private Predicate<Contact> allItems;

    public void initialize() {

        // All contacts predicate for filtered list
        allItems = new Predicate<Contact>() {
            @Override
            public boolean test(Contact contact) {
                return true;
            }
        };

        // filter the list of contacts from ContactData by predicate
        filteredList = new FilteredList<Contact>(ContactData.getInstance().getContacts());
        // sort contacts - compare by last name then first name
        SortedList<Contact> sortedList = new SortedList<>(filteredList,
                Comparator.comparing(Contact::getLastName).thenComparing(Contact::getFirstName)
        );

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
        contactTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        contactTableView.getSelectionModel().selectFirst();
        contactTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    @FXML
    public void showNewContactDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New Contact");
        dialog.setHeaderText("Use this dialog to create a new Contact");
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

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            ContactDialogController controller = fxmlLoader.getController();
            Contact newContact = controller.getContact();
            ContactData.getInstance().addContact(newContact);
            contactTableView.getSelectionModel().select(newContact);
            System.out.println("OK PRESSED");
        } else {
            System.out.println("CANCEL PRESSED");
        }
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
        }
    }

}
