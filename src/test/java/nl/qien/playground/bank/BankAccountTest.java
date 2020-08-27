package nl.qien.playground.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    @Test
    public void deposit(){
        //Arrange
        BankAccount bankAccount = new BankAccount("NL38RABO8027105943");

        //Act
        bankAccount.deposit(50);

        //Assert
        assertEquals(50, bankAccount.getBalance());
    }

    @Test()
    public void depositException(){
        //Arrange
        BankAccount bankAccount = new BankAccount("NL38RABO8027105943");

        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.deposit(-50);
        });

        //Assert
        assertEquals(null,exception.getMessage());
    }
}
