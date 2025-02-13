Here's a README.md file for the Address Book application:

```markdown
# Address Book Application

## Description
This Java application implements a simple Address Book system that allows users to manage contacts. Users can add, view, search, and delete contacts through a command-line interface.

## Features
- Add new contacts with name, email, address, and phone number
- View all contacts in a formatted table
- Search for a contact by phone number
- Delete a contact by phone number
- Simple menu-driven interface

## How to Run
1. Ensure you have Java installed on your system.
2. Compile the Java file:
   ```
   javac AddressBook.java
   ```
3. Run the compiled program:
   ```
   java AddressBook
   ```

## Usage
Upon running the program, you'll be presented with a menu:

1. Add Contact
2. View Contacts
3. Search Contact
4. Delete Contact
5. Exit

Enter the number corresponding to the action you want to perform.

## Classes
- `AddressBook`: Main class containing the program logic and user interface.
- `Contact`: Class representing a single contact with name, email, address, and phone number.

## Methods
- `addContact()`: Adds a new contact to the address book.
- `viewAllContacts()`: Displays all contacts in a formatted table.
- `searchByPhone()`: Searches for a contact by phone number.
- `deleteContact()`: Deletes a contact by phone number.

## Note
This is a basic implementation and does not include data persistence. All contacts are stored in memory and will be lost when the program is closed.

## Author
Arman

## License
This project is open source and available under the [MIT License](LICENSE).