/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package arman.bankaccountmanagementsystem;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Create a new bank account.
Deposit money into an existing bank account.
Withdraw money from an existing bank account.
Check the balance of an existing bank account.
 */

 /*
Entities
1. Bank
2. BankManagementSystem
3. BankAccount
 */
 /*
Feature 1: Create Bank Account
ask user about getHolderName and email?
if the account exists tell show the Acccount number
If does not exists, Create a new Accout with holder name and email, generate a random 10 Digit bank account number.

CONSTRAINS
add the Account to a list of BankAccounts in the Bank. 
accountNumber cannot be duplicated.
Initailize the balance with 0.


Feature 2: Deposit money
Ask the user for the AccoutNumber
if exists
    Ask user for an amount? (Can be double or int)
    get same Instance of the bankAccount and update the balance.
else
    Message "No account found . Do you want to create the account?"
       If yes:
       AddAccount()
       else:
       show menu again

Constarains
1. Cannot add a negative number
2. Cannot add less then $50.




Feature 3: Withdraw an amount
Ask the user for the AccoutNumber
if exists
    Ask user of a withdraw amount (int or double)?
    if after the withdraw the balance is less then 0 then ask the user to change the amount.
    update the balance in users account.
else
    Message "No account found . Do you want to create the account?"
    If yes:
    AddAccount()
    else:
    show menu again

Constrains
    1. Balance cannot be less then 0 after withdrawal.


Feature 4: Check existing bank account.
Ask user for AccountNumber and Name of accountHolder?
if account exits    
    show the bank balance.
else
    Message "No account found . Do you want to create the account?"
    If yes:
    AddAccount()
    else:
    show menu again


 */
public class BankAccountManagementSystem {

    private static Bank bank = Bank.getBank();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int menuSelection;

        do {
            System.out.print(
                    "1. Add Account \n"
                    + "2. Deposit \n"
                    + "3. Withdraw \n"
                    + "4. Show all bank accounts \n"
                    + "5. Generate Report to file \n"
                    + "6. Exit \n"
                    + "Enter your choice: "
            );
            menuSelection = sc.nextInt();

            switch (menuSelection) {
                case 1 -> {
                    String name;
                    String email;

                    System.out.println("What is you Name?");
                    name = sc.next();
                    System.out.println("What is you email?");
                    email = sc.next();
                    BankAccount account = verifyAccount(name, email);

                    if ((account = verifyAccount(name, email)) == null) {
                        addAccount(name, email);
                    } else {
                        System.out.println("Account Already exists: ");
                        System.out.println(account);
                    }

                }
                case 2 -> {

                    String name;
                    String email;

                    System.out.println("What is you Name?");
                    name = sc.next();
                    System.out.println("What is you email?");
                    email = sc.next();
                    BankAccount CustomerAcc;

//verify account
                    if ((CustomerAcc = verifyAccount(name, email)) == null) {
                        System.out.println("No Account Found, Create Account");
                    } else {
                        System.out.println("How much you want to deposit?");
                        double amount = sc.nextDouble();
                        deposit(CustomerAcc, amount);
                    }
                }
                case 3 -> {
                    //   Withdraw:      
                    String name;
                    String email;

                    System.out.println("What is you Name?");
                    name = sc.next();
                    System.out.println("What is you email?");
                    email = sc.next();
                    BankAccount CustomerAcc;

                    if ((CustomerAcc = verifyAccount(name, email)) == null) {
                        System.out.println("No Account Found, Create Account");
                    } else {
                        System.out.println("How much you want to Withdraw?");
                        double amount = sc.nextDouble();
                        withdraw(CustomerAcc, amount);
                    }
                }

                case 4 -> {
                    getAllAccounts();
                }
                case 5 -> {
                try {
                    generateReportToFile();
                } catch (IOException ex) {
                    Logger.getLogger(BankAccountManagementSystem.class.getName()).log(Level.SEVERE, "cannot add file", ex);
                }
                }
                case 6 -> {
                    System.out.println("Bye.. Thank you ");
                }
                default -> {
                    throw new IllegalArgumentException("try again");
                }
            }

        } while (menuSelection != 6);
    }

    private static void addAccount(String name, String email) {
        // This function checks if the account already exist in the database if yes, it will return the account info.
        // If the account is no found in the database it wil create a new account and store it in the database.

        BankAccount acc = null;
        for (int i = 0; i < bank.getAccountList().size(); i++) {

            String holderName = bank.getAccountList().get(i).getHolderName();
            String holderEmail = bank.getAccountList().get(i).getHolderEmail();

            if (holderName.equalsIgnoreCase(name) & holderEmail.equalsIgnoreCase(email)) {

                acc = bank.getAccountList().get(i);
                System.out.println("Account alread Exists: "
                        + bank.getAccountList().get(i).getHolderName()
                        + " " + bank.getAccountList().get(i).getAccNumber());

                break;

            }

        }
        if (acc == null) {
            BankAccount newAccount = new BankAccount(name, email);
            bank.addAccount(newAccount);
            System.out.println("Account Created");
        }

    }

    public static void getAllAccounts() {
        for (BankAccount account : bank.getAccountList()) {
            System.out.println(account);
        }
    }

    public static void deposit(BankAccount customerAcc, double amount) {
        bank.deposit(customerAcc, amount);
    }

    public static void withdraw(BankAccount customerAcc, double amount) {
        bank.withdraw(customerAcc, (amount));
    }

    private static BankAccount verifyAccount(String name, String email) {

        BankAccount acc = null;
        for (int i = 0; i < bank.getAccountList().size(); i++) {

            String holderName = bank.getAccountList().get(i).getHolderName();
            String holderEmail = bank.getAccountList().get(i).getHolderEmail();

            if (holderName.equalsIgnoreCase(name) & holderEmail.equalsIgnoreCase(email)) {

                acc = bank.getAccountList().get(i);
                break;

            }

        }
        return acc;
    }

    private static void generateReportToFile() throws IOException {

        FileWriter fr = new FileWriter("Report.txt", true);

        bank.getAccountList().forEach(account -> {
            try {
                fr.write(account + " \n");
            } catch (IOException ex) {
                Logger.getLogger(BankAccountManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        fr.close();

    }
}
