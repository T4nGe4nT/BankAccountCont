package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        while (true) {
            System.out.println("Welcome to Big Bank");
            System.out.println("Choose an option: ");
            System.out.println("1. Create account with details");
            System.out.println("2. Display all accounts");
            System.out.println("3. Make a deposit");
            System.out.println("4. Make a withdrawal");
            System.out.println("5. Transfer money");
            System.out.println("6. Exit");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (option == 1) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();

                int accountNumber;
                boolean accountExists;

                do {
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Check if the account number already exists
                    accountExists = false;
                    for (BankAccount account : accounts) {
                        if (account.getAccountNumber() == accountNumber) {
                            accountExists = true;
                            System.out.println("Account number already exists. Please enter a different number.");
                            break;
                        }
                    }
                } while (accountExists);

                System.out.print("Enter starting balance: ");
                double balance = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                BankAccount account = new BankAccount(name, accountNumber, balance);
                accounts.add(account);
            } else if (option == 2) {
                for (BankAccount account : accounts) {
                    System.out.println(account);
                }
            } else if (option == 3) {
                System.out.print("Enter account number for deposit: ");
                int accountNumber = scanner.nextInt();
                System.out.print("Enter amount to deposit: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                for (BankAccount account : accounts) {
                    if (account.getAccountNumber() == accountNumber) {
                        account.deposit(amount);
                        break;
                    }
                }
            } else if (option == 4) {
                System.out.print("Enter account number for withdrawal: ");
                int accountNumber = scanner.nextInt();
                System.out.print("Enter amount to withdraw: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                for (BankAccount account : accounts) {
                    if (account.getAccountNumber() == accountNumber) {
                        account.withdraw(amount);
                        break;
                    }
                }
            } else if (option == 5) {
                System.out.print("Enter your account number: ");
                int senderAccountNumber = scanner.nextInt();
                System.out.print("Enter recipient account number: ");
                int recipientAccountNumber = scanner.nextInt();
                System.out.print("Enter amount to transfer: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                BankAccount sender = null;
                BankAccount recipient = null;

                // Find the sender and recipient accounts
                for (BankAccount account : accounts) {
                    if (account.getAccountNumber() == senderAccountNumber) {
                        sender = account;
                    } else if (account.getAccountNumber() == recipientAccountNumber) {
                        recipient = account;
                    }
                }

                if (sender == null) {
                    System.out.println("Sender account not found.");
                } else if (recipient == null) {
                    System.out.println("Recipient account not found.");
                } else {
                    sender.transfer(recipient, amount);
                }
            } else if (option == 6) {
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
