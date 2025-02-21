Here’s a **README.md** for your project, structured to explain its purpose, features, and setup instructions:

---

# **Bank Account Management System**

## **Description**
This Java-based Bank Account Management System allows users to manage their bank accounts. The system supports the following features:

- **Create a Bank Account**
- **Deposit Money**
- **Withdraw Money**
- **Check Account Balance**

The system ensures proper account management, including validation for account creation, deposits, and withdrawals, and maintains a list of bank accounts in the system.

---

## **Entities**
1. **Bank** – Stores a list of all bank accounts.
2. **BankManagementSystem** – Provides operations such as creating accounts, depositing, withdrawing, and checking balance.
3. **BankAccount** – Represents an individual bank account with details like account number, holder name, and balance.

---

## **Features**

### **1. Create Bank Account**
- Ask the user for **holder name** and **email**.
- If an account exists with the same information, the system will show the **account number**.
- If no account exists, the system will create a new account with a **random 10-digit account number**.
- The initial balance will be **set to $0**.
- **Account numbers cannot be duplicated**.
- All created accounts are added to the **Bank’s account list**.

### **2. Deposit Money**
- Ask the user for the **account number**.
- If the account exists, prompt the user for a **deposit amount** (can be int or double).
- The **deposit amount must be greater than or equal to $50** and **cannot be negative**.
- The balance is updated accordingly.
- If the account doesn't exist, the system will prompt the user to **create a new account**.

### **3. Withdraw Money**
- Ask the user for the **account number**.
- If the account exists, ask the user for a **withdrawal amount** (can be int or double).
- **Balance cannot go below $0** after a withdrawal.
- If the withdrawal would cause the balance to go negative, the user is asked to **enter a valid amount**.
- If the account doesn’t exist, the user will be prompted to create a new account.

### **4. Check Account Balance**
- Ask the user for **account number** and **account holder name**.
- If the account exists, show the **current balance**.
- If the account doesn’t exist, ask if the user wants to **create the account**.

---

## **Setup Instructions**

### Prerequisites
- **Java JDK 8 or later** installed on your system.

### Running the Program
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/bank-account-management.git
   ```
2. Navigate to the project directory:
   ```bash
   cd bank-account-management
   ```
3. Compile and run the program:
   ```bash
   javac BankManagementSystem.java
   java BankManagementSystem
   ```

---

## **Project Structure**
```
/bank-account-management
  ├── Bank.java
  ├── BankAccount.java
  ├── BankManagementSystem.java
  └── README.md
```

---

## **Contributing**

1. Fork the repository.
2. Create a new branch for your feature.
3. Commit your changes.
4. Push your branch and create a pull request.

---

## **License**
This project is licensed under the MIT License.


## Credits
This project is created by Arman Bhatia.
