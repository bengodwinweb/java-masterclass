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

    public Contact getContact() {
        String firstName = firstNameField.getText().trim();
        System.out.print("first: " + firstName);
        String lastName = lastNameField.getText().trim();
        System.out.print(", last: " + lastName);
        String phoneNumber = phoneNumberField.getText().trim().replaceAll("[^\\d]", "");
        System.out.println(", phone#: " + phoneNumber);
        String notes = notesArea.getText().trim();

        Contact contact = new Contact(firstName, lastName, phoneNumber, notes);
        return contact;
    }
}
