# PhoneBook Application

A simple Java Swing-based phonebook application that allows users to look up names by phone numbers and phone numbers by names with various search options.

## Features

- Search phone numbers by name
- Search names by phone number
- Search options:
  - Exact Match
  - Starts With (default)
  - Ends With
- Case sensitivity toggle
- Simple GUI interface
- Preloaded with sample contacts

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Java Runtime Environment (JRE)

## Installation

1. Clone the repository:
```bash
git clone https://github.com/ArmanBhatia0100/phonebook.git
```

2. Navigate to the project directory:
```bash
cd phonebook
```

3. Compile the Java file:
```bash
javac PhoneBook.java
```

4. Run the application:
```bash
java PhoneBook
```

## Usage

1. Launch the application
2. To find a number:
   - Enter a name in the "Name" field
   - Press Enter
   - The corresponding number will appear in the "Number" field
3. To find a name:
   - Enter a number in the "Number" field
   - Press Enter
   - The corresponding name will appear in the "Name" field
4. Customize your search:
   - Check "Ignore Case" to make searches case-insensitive
   - Select search type using radio buttons:
     - Exact Match
     - Start With
     - End With

## Sample Contacts

The application comes preloaded with the following contacts:
- John: 555-8765
- Jessica: 555-5643
- Adam: 555-1212
- Reachel: 555-3435
- Tom & Jerry: 555-1001

## Technical Details

- Built using Java Swing for GUI
- Uses GridLayout for component arrangement
- Implements ActionListener for field interactions
- Uses ButtonGroup for radio button exclusivity

## Code Structure

- `PhoneBook.java`: Main class containing all functionality
  - Constructor: Sets up GUI components
  - `lookupName()`: Searches for names by number
  - `lookupNumber()`: Searches for numbers by name
  - `main()`: Application entry point

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing-feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a pull request

## License

[MIT License](LICENSE) - feel free to modify and distribute

## Author

- Arman (original author)

## Future Improvements

- Add ability to save new contacts
- Implement contact deletion
- Add persistent storage
- Include multiple number support per contact
- Add export/import functionality
```
