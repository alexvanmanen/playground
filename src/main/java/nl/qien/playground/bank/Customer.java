package nl.qien.playground.bank;

import java.util.ArrayList;
import java.util.List;

public class Customer {


    private String surName;
    private String firstNames;
    List<BankAccount> bankAccounts = new ArrayList<>();

    public Customer(String firstNames, String lastName) {
        this.firstNames = firstNames;
        this.surName = surName;
    }

    public String getFullName() {
        return firstNames + " " + surName;
    }

    public void addBankAccounts(BankAccount bankAccount) {
        if(bankAccounts.size() <= 3) {
            bankAccounts.add(bankAccount);
        }
        throw new TooMuchBankAccountsException();
    }


}
