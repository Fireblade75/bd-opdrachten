package com.example.h11;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;

public class Bank  {
    private final BigDecimal interestRate;
    private final List<BankAccount> bankAccounts = new ArrayList<>();

    private int nextAccount = 100;

    public Bank(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BankAccount createAccount(AccountType accountType, BigDecimal balance) {
        int accountNumber = nextAccount++;
        BankAccount bankAccount = null;

        if(accountType.equals(AccountType.CHECKING)) {
            bankAccount = new CheckingAccount(accountNumber, balance);
        } else if(accountType.equals(AccountType.SAVING)) {
            bankAccount = new SavingsAccount(accountNumber, balance);
        } ;

        if(bankAccount != null) {
            bankAccounts.add(bankAccount);
            return bankAccount;
        } else {
            throw new UnsupportedOperationException("Unsupported Account type");
        }
    }

    public void transfer(BankAccount from, BankAccount to, BigDecimal amount) {
        from.transfer(to, amount);
    }

    public BigDecimal getBalance(BankAccount bankAccount) {
        return bankAccount.balance;
    }

    public BigDecimal getInterest(BankAccount bankAccount) {
        return bankAccount.calculateInterest();
    }

    public void applyInterest() {
        bankAccounts.forEach(BankAccount::applyInterest);
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("\n");
        bankAccounts.forEach(ba -> sj.add(ba.toString()));
        return sj.toString();
    }

    private abstract class BankAccount {
        private final int accountNumber;
        protected BigDecimal balance;

        public BankAccount(int accountNumber, BigDecimal balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        void transfer(BankAccount to, BigDecimal amount) {
            if(balance.compareTo(amount) < 0) {
                throw new InsufficientBalanceException();
            } else {
                balance = balance.subtract(amount);
                to.balance = to.balance.add(amount);
            }
        }

        public abstract BigDecimal calculateInterest();

        private void applyInterest() {
            balance = balance.add(calculateInterest());
        }

        protected abstract BigDecimal getInterestRate();

        @Override
        public String toString() {
            return String.format("SavingsAccount %d: € %.02f ; Interest Rate %.01f%%",
                    accountNumber, balance.doubleValue(), getInterestRate());
        }
    }

    private class CheckingAccount extends BankAccount {

        public CheckingAccount(int accountNumber, BigDecimal balance) {
            super(accountNumber, balance);
        }

        @Override
        public BigDecimal calculateInterest() {
            return BigDecimal.ZERO;
        }

        @Override
        protected BigDecimal getInterestRate() {
            return BigDecimal.ZERO;
        }


    }

    private class SavingsAccount extends BankAccount {

        public SavingsAccount(int accountNumber, BigDecimal balance) {
            super(accountNumber, balance);
        }

        @Override
        public BigDecimal calculateInterest() {
            return balance.multiply(interestRate);
        }

        @Override
        protected BigDecimal getInterestRate() {
            return interestRate;
        }
    }

    public static class InsufficientBalanceException extends RuntimeException {

        private static final long serialVersionUID = -1209706292929100705L;
    }
}
