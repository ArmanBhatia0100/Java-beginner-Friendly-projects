/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package arman.bankaccountmanagementsystem;

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
ask user about holderName and email?
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

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
