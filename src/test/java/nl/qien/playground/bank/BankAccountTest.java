package nl.qien.playground.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {

    @Test
    public void deposit(){
        BankAccount bankAccount = new BankAccount("NL38RABO8027105943");

        bankAccount.deposit(50);

        assertEquals(50, bankAccount.getBalance());
    }
}
