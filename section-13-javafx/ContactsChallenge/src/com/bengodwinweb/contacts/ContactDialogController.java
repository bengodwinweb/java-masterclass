package com.bengodwinweb.contacts;

import com.bengodwinweb.contacts.datamodel.Contact;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ContactDialogController {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextArea notesArea;

    // creates a new contact from the form data
    public Contact getContact() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String phoneNumber = phoneNumberField.getText().trim();
        String notes = notesArea.getText().trim();

        Contact contact = new Contact(firstName, lastName, phoneNumber, notes);
        return contact;
    }

    // Use this method to set the text in each field for editing a contact
    public void setContact(Contact contact) {
        firstNameField.setText(contact.getFirstName());
        lastNameField.setText(contact.getLastName());
        phoneNumberField.setText(contact.getPhoneNumber());
        notesArea.setText(contact.getNotes());
    }
}
