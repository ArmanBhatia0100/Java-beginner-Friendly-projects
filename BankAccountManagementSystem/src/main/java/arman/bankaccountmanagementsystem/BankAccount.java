/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arman.bankaccountmanagementsystem;

import java.util.Random;

/**
 *
 * @author arman
 */
public class BankAccount {

    private String holderName;
    private String holderEmail;
    private final int accNumber;
    private double balance = 0;

    public BankAccount(String holderName, String holderEmail) {
        this.holderName = holderName;
        this.holderEmail = holderEmail;
        this.accNumber = new Random().nextInt(1000000000);
    }

    public String getHolderName() {
        return holderName;
    }

    public String getHolderEmail() {
        return holderEmail;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public double getBalance() {
        return balance;
    }
    

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setBalance(double amount) {
        this.balance += amount;
    }

    @Override
    public String toString() {
        return "BankAccount => " + "holderName=" + holderName + ", accNumber=" + accNumber + ", balance=" + balance;
    }

}
