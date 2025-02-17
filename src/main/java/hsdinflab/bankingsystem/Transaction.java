package hsdinflab.bankingsystem;

public class Transaction {
    public String type; public int accountNumber; public double amount;

    public Transaction(String type, int accountNumber, double amount) {
        this.type = type;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", accountNumber=" + accountNumber +
                ", amount=" + amount +
                '}';
    }
}
