package com.example.java.chapters.h11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    Bank bank;

    @BeforeEach
    void setup() {
        bank = new Bank(new BigDecimal("0.10"));
    }

    @Test
    void interestTest() {
        var savingAccount  = bank.createAccount(AccountType.SAVING, new BigDecimal("100.00"));
        var checkingAccount = bank.createAccount(AccountType.CHECKING, new BigDecimal("100.00"));

        assertEquals(bank.getInterest(savingAccount).compareTo(new BigDecimal("10.00")), 0);
        assertEquals(bank.getInterest(checkingAccount).compareTo(new BigDecimal("0.00")), 0);

        bank.applyInterest();

        assertEquals(bank.getBalance(savingAccount).compareTo(new BigDecimal("110.00")), 0);
        assertEquals(bank.getBalance(checkingAccount).compareTo(new BigDecimal("100.00")), 0);
    }

    @Test
    void transferTest() {
        var accountA  = bank.createAccount(AccountType.CHECKING, new BigDecimal("100.00"));
        var accountB = bank.createAccount(AccountType.CHECKING, new BigDecimal("100.00"));

        bank.transfer(accountA, accountB, new BigDecimal("50.00"));
        assertEquals(bank.getBalance(accountA).compareTo(new BigDecimal("50.00")), 0);
        assertEquals(bank.getBalance(accountB).compareTo(new BigDecimal("150.00")), 0);

        bank.transfer(accountA, accountB, new BigDecimal("50.00"));
        assertEquals(bank.getBalance(accountA).compareTo(new BigDecimal("00.00")), 0);
        assertEquals(bank.getBalance(accountB).compareTo(new BigDecimal("200.00")), 0);

        assertThrows(Bank.InsufficientBalanceException.class, () -> {
            bank.transfer(accountA, accountB, new BigDecimal("5.00"));
        });
    }

    @Test
    void printTest() {
        var accountA  = bank.createAccount(AccountType.CHECKING, new BigDecimal("100.00"));
        var accountB = bank.createAccount(AccountType.CHECKING, new BigDecimal("40.30"));
        var accountC = bank.createAccount(AccountType.CHECKING, new BigDecimal("180.70"));

        bank.transfer(accountA, accountB, new BigDecimal("33.72"));

        String bankRes = bank.toString();
        assertTrue(bankRes.contains("€ 66,28"));
        assertTrue(bankRes.contains("€ 74,02"));
        assertTrue(bankRes.contains("€ 180,70"));
    }
}