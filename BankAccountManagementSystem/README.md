# Bank Account Management System

**Author:** Arman  
**Date:** February 24, 2025  
**Package:** `arman.bankaccountmanagementsystem`

Welcome to the **Bank Account Management System**, a sleek and efficient Java application designed to manage bank accounts with ease. Whether you're creating accounts, depositing funds, withdrawing money, or generating reports, this system has you covered—all wrapped in a user-friendly console interface. Built with clean code and thoughtful design, it’s a perfect blend of functionality and simplicity.

---

## Overview

This project simulates a basic banking system with core functionalities to manage accounts. It leverages object-oriented principles and a singleton `Bank` class to maintain a centralized list of `BankAccount` objects. Whether you're a beginner learning Java or a seasoned coder exploring practical applications, this system offers a robust foundation to build upon.

### Entities
1. **Bank**: The central entity managing all accounts (singleton pattern).
2. **BankManagementSystem**: The main class driving the console-based interface.
3. **BankAccount**: Represents individual accounts with holder details, account number, and balance.

---

## Features

### 1. Create a New Bank Account
- **What it Does**: Prompts for the account holder's name and email, then creates a new account if it doesn’t already exist.
- **How it Works**:
  - Checks if an account with the same name and email exists.
  - If it exists, displays the existing account number.
  - If not, generates a unique 10-digit account number and initializes the balance to $0.
- **Constraints**:
  - Account numbers are unique and randomly generated.
  - Accounts are stored in a list within the `Bank` class.

### 2. Deposit Money
- **What it Does**: Allows depositing funds into an existing account.
- **How it Works**:
  - Asks for the account holder’s name and email to verify the account.
  - If found, prompts for a deposit amount and updates the balance.
  - If not found, offers to create a new account.
- **Constraints**:
  - Deposit amount must be at least $50.
  - Negative amounts are not allowed.

### 3. Withdraw Money
- **What it Does**: Facilitates withdrawing funds from an existing account.
- **How it Works**:
  - Verifies the account using the holder’s name and email.
  - If found, prompts for a withdrawal amount and updates the balance.
  - If the withdrawal would result in a negative balance, prompts for a new amount.
  - If not found, offers to create a new account.
- **Constraints**:
  - Balance cannot drop below $0 after withdrawal.

### 4. Check Account Balance
- **What it Does**: Displays the balance of an existing account.
- **How it Works**:
  - Verifies the account by name and email.
  - If found, shows the current balance.
  - If not found, offers to create a new account.

### 5. Show All Accounts
- **What it Does**: Lists all accounts managed by the bank.
- **How it Works**: Iterates through the `Bank`’s account list and prints each account’s details.

### 6. Generate Report to File
- **What it Does**: Exports all account details to a `Report.txt` file.
- **How it Works**: Uses `FileWriter` to append account information to the file, ensuring persistence across runs.

---

## How to Use

### Prerequisites
- Java Development Kit (JDK) 8 or higher installed.
- An IDE (e.g., NetBeans, IntelliJ) or a command-line environment to compile and run the code.

### Running the Program
1. Clone or download the project to your local machine.
2. Navigate to the `src` directory:  
   ```
   cd src/arman/bankaccountmanagementsystem
   ```
3. Compile the Java files:  
   ```
   javac BankAccountManagementSystem.java
   ```
4. Run the application:  
   ```
   java BankAccountManagementSystem
   ```
5. Follow the interactive menu to manage accounts!

### Menu Options
```
1. Add Account
2. Deposit
3. Withdraw
4. Show all bank accounts
5. Generate Report to file
6. Exit
Enter your choice: 
```

---

## Code Structure

- **`BankAccountManagementSystem.java`**: The main class with the console interface and menu logic.
- **`Bank.java`** (assumed): A singleton class managing the list of accounts and core operations (e.g., `addAccount`, `deposit`, `withdraw`).
- **`BankAccount.java`** (assumed): Represents individual accounts with fields like `holderName`, `holderEmail`, `accNumber`, and `balance`.

### Key Methods
- `addAccount(String name, String email)`: Creates or retrieves an account.
- `deposit(BankAccount account, double amount)`: Adds funds with validation.
- `withdraw(BankAccount account, double amount)`: Removes funds with balance checks.
- `verifyAccount(String name, String email)`: Checks if an account exists.
- `generateReportToFile()`: Writes account data to `Report.txt`.

---

## Constraints & Design Choices
- **Unique Account Numbers**: Ensures no duplicates for reliable identification.
- **Minimum Deposit ($50)**: Encourages meaningful transactions.
- **Non-Negative Balance**: Protects against overdrafts.
- **Case-Insensitive Verification**: Matches names and emails flexibly (e.g., "arman" = "Arman").
- **File Persistence**: Appends to `Report.txt` for record-keeping.

---

## Future Enhancements
- Add PIN or password authentication for security.
- Implement a GUI using JavaFX or Swing for a modern look.
- Store data in a database (e.g., SQLite) instead of memory and files.
- Support multiple currencies or interest calculations.

---

## About the Author
Hi, I’m **Arman**, the creator of this Bank Account Management System! I built this project to explore Java’s object-oriented features and create a practical tool that’s both functional and fun to use. Feel free to fork, tweak, or contribute—I’d love to see where this system can go!

---

## License
This project is open-source under the default license (see `license-default.txt` in the project files). Feel free to use, modify, and share it as you see fit!

---

Enjoy managing your virtual bank with ease and style! Let me know if you have questions or ideas—happy coding!