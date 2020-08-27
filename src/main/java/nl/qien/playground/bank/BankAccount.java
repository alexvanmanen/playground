package nl.qien.playground.bank;

public class BankAccount {

    private final String iban;
    private double balance;

    public BankAccount(String iban) {
        this.iban = iban;
    }

    public void deposit(double depositAmount) {
        if(depositAmount <= 0) {
            throw new IllegalArgumentException();
        }
        balance += depositAmount;
    }

    public void withdraw(double withdrawAmount) {
        if(withdrawAmount <= 0) {
            throw new IllegalArgumentException();
        } else if(withdrawAmount < balance) {
            throw new WithdrawalException();
        }
        balance -= withdrawAmount;
    }

    public double getBalance() {
        return balance;
    }

    public String getIban() {
        return iban;
    }
}
