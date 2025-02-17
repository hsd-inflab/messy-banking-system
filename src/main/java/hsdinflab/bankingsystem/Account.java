package hsdinflab.bankingsystem;

public class Account {
    public int accountNumber;
    public String owner;
    public double balance;

    public Account(int accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", owner='" + owner + '\'' +
                ", balance=" + balance +
                '}';
    }
}
