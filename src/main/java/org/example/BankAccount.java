package org.example;

import java.util.Scanner;

public class BankAccount {
    private int accountNumber;
    private double balance;
    private String name;

    // Constructor for when we instantiate an instance of it in main class. (Original Constructor)
    public BankAccount(String name, int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    // Constructor that takes no parameters and allows user input
    public BankAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account number: ");
        this.accountNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter name: ");
        this.name = scanner.nextLine();

        System.out.print("Enter starting balance: ");
        this.balance = scanner.nextDouble();
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Deposited " + amount + " to " + name);
        System.out.println("New balance: " + this.balance);
    }

    public void withdraw(double amount) {
        this.balance -= amount;
        System.out.println(this.name + " Withdrew " + amount + " remaining balance is " + this.balance);
    }

    public void getBalance() {
        System.out.println("Balance for " + name + ": " + this.balance);
    }

    // Transfer method
    public void transfer(BankAccount recipient, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid transfer amount.");
            return;
        }
        if (this.balance < amount) {
            System.out.println("Insufficient funds.");
            return;
        }
        this.withdraw(amount);
        recipient.deposit(amount);
        System.out.println("Transferred " + amount + " from " + this.name + " to " + recipient.getName());
    }

    // Getter for accountNumber
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() { // So it returns as a JSON
        return "BankAccount{name='" + name + "', accountNumber=" + accountNumber + ", balance=" + balance + '}';
    }
}

