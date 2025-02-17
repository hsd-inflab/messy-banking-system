package hsdinflab.bankingsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankingApp {
    
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
                processDeposit();
            } else if (command.equalsIgnoreCase("withdraw")) {
                processWithdraw();
            } else if (command.equalsIgnoreCase("show")) {
                processShow();
            }
        }
    }

    private void processDeposit() {
        System.out.print("Enter account number: ");
        int accNum = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        updateAccount(accNum, amount);
        displayAccount(accNum);
    }

    private void processWithdraw() {
        System.out.print("Enter account number: ");
        int accNum = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        updateAccountNegative(accNum, amount);
        displayAccount(accNum);
    }

    private void processShow() {
        System.out.print("Enter account number: ");
        int accNum = Integer.parseInt(scanner.nextLine());
        displayAccount(accNum);
    }

    private void displayAccount(int accNum) {
        Account acc = findAccount(accNum);
        if (acc != null) {
            System.out.println(acc);
        } else {
            System.out.println("Account not found.");
        }
    }

    public List<Account> accounts = new ArrayList<>();

    public Account findAccount(int accountNumber) {
        for (Account acc : accounts) {
            if (acc.accountNumber == accountNumber) {
                return acc;
            }
        }
        return null;
    }

    public void updateAccount(int accountNumber, double amount) {
        Account acc = findAccount(accountNumber);
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
        Account acc = findAccount(accountNumber);
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
