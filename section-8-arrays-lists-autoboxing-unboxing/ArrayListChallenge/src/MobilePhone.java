import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> contacts;
    private String[] menu;

    public MobilePhone() {
        contacts = new ArrayList<>();
        menu = new String[] {"store", "modify", "remove", "find"};
    }

    public void printMenu() {
        System.out.println("Press:");
        System.out.println("\t 0 - To print menu options.");
        for (int i = 0; i < menu.length; i++) {
            System.out.println("\t " + (i + 1) + " - To " + menu[i] + " a contact.");
        }
        System.out.println("\t " + (menu.length + 1) + " - To print all contacts.");
        System.out.println("\t " + (menu.length + 2) + " - To turn off the phone.");
    }

    public void printContacts() {
        System.out.println("Contacts - " + contacts.size() + " found");
        contacts.forEach(contact -> System.out.println("Name: " + contact.getName() + ", Number: " + contact.getPhoneNumber()));
    }

    public void storeContact(String name, String phoneNumber) {
        int index = getIndex(name);
        if (index < 0) {
            contacts.add(new Contact(name, phoneNumber));
        } else {
            System.out.println("Unable to store - name matches existing contact");
        }

    }

    public void modifyContact(String oldName, String newName, String phoneNumber) {
        int index = getIndex(oldName);
        if (index >= 0) {
            contacts.get(index).setName(newName);
            contacts.get(index).setPhoneNumber(phoneNumber);
        } else {
            System.out.println("Unable to update - could not find contact matching that name");
        }
    }

    public void removeContact(String name) {
        int index = getIndex(name);
        if (index >= 0) {
            contacts.remove(index);
        } else {
            System.out.println("Unable to remove - could not find contact matching that name");
        }
    }

    public void findContact(String name) {
        int index = getIndex(name);
        if (index >= 0) {
            Contact contact = contacts.get(index);
            System.out.println("Found Contact - Name: " + contact.getName() + ", Phone Number: " + contact.getPhoneNumber());
        } else {
            System.out.println("No contact found with that name");
        }
    }

    private int getIndex(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
