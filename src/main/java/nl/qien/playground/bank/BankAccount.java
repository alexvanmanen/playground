package nl.qien.playground.bank;

public class BankAccount {

    private final String iban;
    private double balance;

    public BankAccount(String iban) {
        this.iban = iban;
    }

    public void deposit(double depositAmount) {
        balance += depositAmount;
    }

    public void withdraw(double withdrawAmount) {
        balance -= withdrawAmount;
    }

    public double getBalance() {
        return balance;
    }

    public String getIban() {
        return iban;
    }
}
