package com.bengodwinweb.contacts.datamodel;

import java.time.LocalDateTime;

public class Contact {
    // first name
    private String firstName;
    // last name
    private String lastName;
    // phone number
    private String phoneNumber;
    // notes
    private String notes;
    // date created
    private LocalDateTime created;

    public Contact() {
    }

    public Contact(String firstName, String lastName, String phoneNumber, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = sanitizePhoneNumber(phoneNumber);
        this.notes = notes;
        this.created = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return formatPhoneNumber(phoneNumber);
    }

    public String getRawPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = sanitizePhoneNumber(phoneNumber);
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public static String sanitizePhoneNumber(String s) {
        return s.replaceAll("[^\\d]", "");
    }

    public static String formatPhoneNumber(String s) {
        return s.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
    }
}
