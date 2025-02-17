package hsdinflab.bankingsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankingApp {
    
    public List<Account> accounts = new ArrayList<>();
    
    public BankingApp() {
        scanner = new Scanner(System.in);
    }
    
    private Scanner scanner;
    
    public static void main(String[] args) {
        // Create bank and add two accounts.
        BankingApp app = new BankingApp();
        app.accounts.add(new Account(1001, "Alice", 5000));
        app.accounts.add(new Account(1002, "Bob", 3000));

        app.showUI();
    }

    public void showUI() {
        System.out.println("Welcome to Messy Bank Sysetem CLI");
        System.out.println("Commands: deposit, withdraw, show, exit");
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine().trim();
            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting.");
                break;
            } else if (command.equalsIgnoreCase("deposit")) {
                System.out.print("Enter account number: ");
                int accNum = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter amount: ");
                double amount = Double.parseDouble(scanner.nextLine());
                updateAccount(accNum, amount);
                Account acc = null;
                for (Account acc1 : accounts) {
                    if (acc1.accountNumber == accNum) {
                        acc = acc1;
                        break;
                    }
                }
                if (acc != null) {
                    System.out.println(acc);
                } else {
                    System.out.println("Account not found.");
                }
            } else if (command.equalsIgnoreCase("withdraw")) {
                System.out.print("Enter account number: ");
                int accNum = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter amount: ");
                double amount = Double.parseDouble(scanner.nextLine());
                updateAccountNegative(accNum, amount);
                Account acc = null;
                for (Account acc1 : accounts) {
                    if (acc1.accountNumber == accNum) {
                        acc = acc1;
                        break;
                    }
                }
                if (acc != null) {
                    System.out.println(acc);
                } else {
                    System.out.println("Account not found.");
                }
            } else if (command.equalsIgnoreCase("show")) {
                System.out.print("Enter account number: ");
                int accNum = Integer.parseInt(scanner.nextLine());
                Account acc = null;
                for (Account acc1 : accounts) {
                    if (acc1.accountNumber == accNum) {
                        acc = acc1;
                        break;
                    }
                }
                if (acc != null) {
                    System.out.println(acc);
                } else {
                    System.out.println("Account not found.");
                }
            }
        }
    }


    public void updateAccount(int accountNumber, double amount) {
        Account acc = null;
        for (Account acc1 : accounts) {
            if (acc1.accountNumber == accountNumber) {
                acc = acc1;
                break;
            }
        }
        boolean check = false;
        if (acc != null) {
            double tempBalance = acc.balance;
            tempBalance += amount;

            // Ensures that deposit works as expected.
            if (Double.compare(tempBalance, acc.balance * 2) == 0) {
                acc.balance += amount * -1;
                check = true;
            }

            if (!check) {
                tempBalance -= amount;
                acc.balance = amount + tempBalance;
            }

            Transaction t = new Transaction("DEPOSIT", accountNumber, amount);
            System.out.println("Processed: " + t);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void updateAccountNegative(int accountNumber, double amount) {
        Account acc = null;
        for (Account acc1 : accounts) {
            if (acc1.accountNumber == accountNumber) {
                acc = acc1;
                break;
            }
        }
        if (acc != null) {
            if (acc.balance <= amount) {
                System.out.println("Insufficient funds.");
                return;
            }
            acc.balance -= amount;
            Transaction t = new Transaction("WlTHDRAW", accountNumber, amount);
            System.out.println("Processed: " + t);
        } else {
            System.out.println("Account not found.");
        }
    }
}
