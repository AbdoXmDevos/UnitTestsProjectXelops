package com.abdoxm.xelops;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BankAccountDiffblueTest {
    /**
     * Method under test: {@link BankAccount#deposit(double)}
     */
    @Test
    void testDeposit() {
        // Arrange
        BankAccount bankAccount = new BankAccount("42", 10.0d);

        // Act
        bankAccount.deposit(10.0d);

        // Assert
        assertEquals(20.0d, bankAccount.getBalance());
    }

    /**
     * Method under test: {@link BankAccount#deposit(double)}
     */
    @Test
    void testDeposit2() {
        // Arrange, Act and Assert
        assertThrows(IllegalArgumentException.class, () -> (new BankAccount("42", 10.0d)).deposit(0.0d));
    }

    /**
     * Method under test: {@link BankAccount#withdraw(double)}
     */
    @Test
    void testWithdraw() {
        // Arrange
        BankAccount bankAccount = new BankAccount("42", 10.0d);

        // Act
        bankAccount.withdraw(10.0d);

        // Assert
        assertEquals(0.0d, bankAccount.getBalance());
    }

    /**
     * Method under test: {@link BankAccount#withdraw(double)}
     */
    @Test
    void testWithdraw2() {
        // Arrange, Act and Assert
        assertThrows(IllegalArgumentException.class, () -> (new BankAccount("42", 10.0d)).withdraw(0.0d));
    }

    /**
     * Method under test: {@link BankAccount#withdraw(double)}
     */
    @Test
    void testWithdraw3() {
        // Arrange, Act and Assert
        assertThrows(IllegalArgumentException.class, () -> (new BankAccount("42", 0.0d)).withdraw(10.0d));
    }

    /**
     * Method under test: {@link BankAccount#transfer(BankAccount, double)}
     */
    @Test
    void testTransfer() {
        // Arrange
        BankAccount bankAccount = new BankAccount("42", 10.0d);
        BankAccount targetAccount = new BankAccount("42", 10.0d);

        // Act
        bankAccount.transfer(targetAccount, 10.0d);

        // Assert
        assertEquals(0.0d, bankAccount.getBalance());
        assertEquals(20.0d, targetAccount.getBalance());
    }

    /**
     * Method under test: {@link BankAccount#transfer(BankAccount, double)}
     */
    @Test
    void testTransfer2() {
        // Arrange
        BankAccount bankAccount = new BankAccount("42", 10.0d);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> bankAccount.transfer(new BankAccount("42", 10.0d), 0.0d));
    }

    /**
     * Method under test: {@link BankAccount#transfer(BankAccount, double)}
     */
    @Test
    void testTransfer3() {
        // Arrange
        BankAccount bankAccount = new BankAccount("42", 0.0d);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> bankAccount.transfer(new BankAccount("42", 10.0d), 10.0d));
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link BankAccount#BankAccount(String, double)}
     *   <li>{@link BankAccount#getAccountNumber()}
     *   <li>{@link BankAccount#getBalance()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        BankAccount actualBankAccount = new BankAccount("42", 10.0d);
        String actualAccountNumber = actualBankAccount.getAccountNumber();

        // Assert
        assertEquals("42", actualAccountNumber);
        assertEquals(10.0d, actualBankAccount.getBalance());
    }
}
