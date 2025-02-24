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

    public void deposit(BankAccount CustomerAcc, double amount) {
        double currentBalance = CustomerAcc.getBalance();
        double amountToAdd = Math.abs(amount);
        double finalAmount = currentBalance + amountToAdd;

        if (finalAmount >= 0) {
            CustomerAcc.setBalance(finalAmount);
        } 
    }

    public void withdraw(BankAccount CustomerAcc, double amount) {
        double currentBalance = CustomerAcc.getBalance();
        double amountToMinus =  Math.abs(amount);
        double finalAmount = currentBalance - amountToMinus;

        if (currentBalance > 0 && finalAmount >= 0) {
            CustomerAcc.setBalance(finalAmount);
        } else {
            System.out.println("Sorry not enough balance to withdraw, Change amount");
        }
    }

    public ArrayList<BankAccount> getAccountList() {
        return accountList;
    }

}
