package nl.qien.playground.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    BankAccount bankAccount;

    /*
        1. Schrijf alle scenario's die je kunt bedenken met behulp van equivalantieklassen
        en grenswaarde-analyse op.
            Voorbeeld:
                -1, 0, +1, MAX_VALUE

                deposit(50); - verwachting: getBalance() == 50
                deposit(-50); - verwachting: IllegalArgumentException

        2. Schrijf alle scenario's uit in unit tests
            Zie hieronder


     */

    @BeforeEach
    public void init() {
        bankAccount = new BankAccount("NL38RABO8027105943");
    }


    @Test
    public void deposit() {
        bankAccount.deposit(0.01);
        assertEquals(0.01, bankAccount.getBalance());
    }

    @Test
    public void depositMax() {
        bankAccount.deposit(Double.MAX_VALUE);
        bankAccount.deposit(Double.MAX_VALUE);
        assertEquals(Double.POSITIVE_INFINITY, bankAccount.getBalance());
    }

    @Test()
    public void depositMinus() {
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.deposit(-0.01);
        });
    }

    @Test()
    public void depositNone() {
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.deposit(-0);
        });
    }

    @Test
    public void withdraw() {
        bankAccount.deposit(0.01);
        bankAccount.withdraw(0.01);
        assertEquals(0.00, bankAccount.getBalance());
    }

    @Test()
    public void withdrawMinus() {
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(-0.01);
        });
    }

    @Test()
    public void withdrawZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(0);
        });
    }


}
