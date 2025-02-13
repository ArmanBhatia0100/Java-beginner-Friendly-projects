/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package arman.addressbook;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

/**
 *
 * @author arman
 */
public class AddressBook {

    static Scanner scannerInput = new Scanner(System.in);
    private static final ArrayList<Contact> contactList = new ArrayList();

    public static void main(String[] args) {
        int isCorrectOption;
        do {
            System.out.println("");
            System.out.println("ADDRESS BOOK");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            isCorrectOption = scannerInput.nextInt();
            System.out.println("");

            switch (isCorrectOption) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewAllContacts();
                    break;
                case 3:
                    searchByPhone();
                    break;
                case 4:
                    deleteContact();
                    break;
                default:
                    System.out.println("Existing address book");

            }
        } while (isCorrectOption != 5);

    }

    public static void addContact() {
        // get informartin from the keyborad
        String name;
        String email;
        String address;
        int phone;

        Scanner userInput = new Scanner(System.in);

        try {
            System.out.println("Enter the name ?");
            name = userInput.next();

            System.out.println("Enter the email?");
            email = userInput.next();

            System.out.println("Enter the address ?");
            address = userInput.next();

            System.out.println("Enter the phone ?");
            phone = userInput.nextInt();

            // create a contact object
            Contact newContact = new Contact(name, email, address, phone);

            // add it to array list
            contactList.add(newContact);

        } catch (InputMismatchException e) {
            // check the input intigrity
            System.out.println(e.getMessage());
        }

    }

    public static void viewAllContacts() {

        System.out.printf("%-20s %-20s %-25s %-12s", "Name", "Email", "Address", "Phone");
        System.out.println("");

        for (Contact contact : contactList) {
            System.out.printf("%-20s %-20s %-25s %-12d \n", contact.getName(), contact.getEmail(), contact.getAddress(), contact.getPhone());
        }

    }

    public static void searchByPhone() {

        int numberToSearch;
        Contact contactFound = null;
        Scanner userInput = new Scanner(System.in);

        System.out.println("What is the number to search?");
        numberToSearch = userInput.nextInt();

        // Loop to find the contact
        for (int i = 0; i < contactList.size(); i++) {

            if (contactList.get(i).getPhone() == numberToSearch) {
                contactFound = contactList.get(i);
            }

        }

        // checking if the contact is found or not.
        if (contactFound != null) {
            System.out.printf("%-20s %-20s %-25s %-12s", "Name", "Email", "Address", "Phone \n");
            System.out.printf("%-20s %-20s %-25s %-12d \n", contactFound.getName(), contactFound.getEmail(), contactFound.getAddress(), contactFound.getPhone());

        } else {
            System.out.println("No Contact Found");
        }
    }

    public static void deleteContact() {
        int numberToDelete;
        Contact contactFound = null;
        Scanner userInput = new Scanner(System.in);

        System.out.println("What is the number to Delete?");
        numberToDelete = userInput.nextInt();

        // Loop to find the contact
        for (int i = 0; i < contactList.size(); i++) {

            if (contactList.get(i).getPhone() == numberToDelete) {
                contactFound = contactList.get(i);
            }
        }
        // delete the contact

        if (contactList.remove(contactFound)) {
            System.out.println("Contact Removed");
        } else {
            System.out.println("Contact not found: " + contactFound);
        }
    }
}

class Contact {

    private String name;
    private String email;
    private String address;
    private int phone;

    public Contact(String name, String email, String address, int phone) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return " " + name + " " + email + " " + address + " " + phone + ' ';
    }

}
