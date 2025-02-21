/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arman.bankaccountmanagementsystem;

import java.util.ArrayList;

/**
 *
 * @author arman
 */
public class Bank {

    private static Bank bankInstance = new Bank();

    private ArrayList<BankAccount> accountList = new ArrayList<>();

    private Bank() {
    }

    public static Bank getBank() {
        return bankInstance;
    }

    public void addAccount(BankAccount bankAcc) {
        accountList.add(bankAcc);
    }

    public ArrayList<BankAccount> getAccountList() {
        return accountList;
    }
    
    

}
