package com.example.bankapp;

import com.example.bankapp.exceptions.BankTransferFailedException;
import com.example.bankapp.exceptions.UnknownBankAccountException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    public void testPrint() {
        Bank bank = new Bank();
        Customer customer = bank.addCustomer("Bob", "Jansen");
        Iban iban = bank.addAccount(customer, 3100072456L, 480);
        assertEquals(bank.getBalance(iban), 480, 0.001);
        double interest = bank.getInterestRate() * 480;
        String expectedText = String.format("NL00BANK3100072456: € 480,00 - Interest next year: %.02f%n", interest);
        assertEquals(bank.toString(), expectedText);

    }

    @Test
    public void testWithdraw() {
        Bank bank = new Bank();
        Customer customer = bank.addCustomer("Bob", "Jansen");
        Iban iban1 = bank.addAccount(customer, 3100072456L, 480);
        Iban iban2 = bank.addAccount(customer, 8877477636L, 200);
        bank.transferMoney(iban1, iban2, 400);
        System.out.println(bank.toString());
    }

    @Test
    public void testWithdrawEqual() {
        Bank bank = new Bank();
        Customer customer = bank.addCustomer("Bob", "Jansen");
        Iban iban1 = bank.addAccount(customer, 3100072456L, 480);
        Iban iban2 = bank.addAccount(customer, 8877477636L, 200);
        bank.transferMoney(iban1, iban2, 480);
        System.out.println(bank.toString());
    }

    @Test
    public void testWithdrawTooMuch() {
        Bank bank = new Bank();
        Customer customer = bank.addCustomer("Bob", "Jansen");
        Iban iban1 = bank.addAccount(customer, 4520711568L, 280);
        Iban iban2 = bank.addAccount(customer, 8877477636L, 200);
        assertThrows(BankTransferFailedException.class, () -> {
            bank.transferMoney(iban1, iban2, 400);
            System.out.println(bank.toString());
        });
    }

    @Test
    public void testWithdrawNonExistent() {
        Bank bank = new Bank();
        Customer customer = bank.addCustomer("Kim", "Simson");
        Iban existingIban = bank.addAccount(customer ,8877477636L, 200);
        Iban fakeIban = new Iban("NL", 0, "FAKE", 2859779760L);

        assertThrows(UnknownBankAccountException.class, () -> {
            bank.transferMoney(fakeIban, existingIban, 400);
            System.out.println(bank.toString());
        });
    }
}