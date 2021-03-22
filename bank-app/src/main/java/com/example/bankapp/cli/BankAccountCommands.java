package com.example.bankapp.cli;

import com.example.bankapp.Bank;
import com.example.bankapp.Customer;
import com.example.bankapp.Iban;
import com.example.bankapp.exceptions.InvalidIbanException;
import com.example.bankapp.exceptions.UnknownBankAccountException;

import java.util.List;
import java.util.stream.Collectors;

public class BankAccountCommands {
    public static String transfer(Bank bank, String[] words) {
        if (words.length != 4) {
            return "Usage: transfer from[IBAN] to[IBAN] amount[double]";
        } else {
            Iban fromIban = Iban.parseIban(words[1]);
            Iban toIban = Iban.parseIban(words[2]);
            double amount = Double.parseDouble(words[3]);
            bank.transferMoney(fromIban, toIban, amount);
            return String.format("Transferred %.02f from %s to %s", amount, fromIban.toString(), toIban.toString());
        }
    }

    public static String createNewAccount(Bank bank, String[] words) {
        if (words.length != 4) {
            return "Usage: createAccount customerId IBAN balance";
        }
        try {
            int customerId = Integer.parseInt(words[1]);
            Iban iban = Iban.parseIban(words[2]);
            double balance = Double.parseDouble(words[3]);

            Customer customer = bank.getCustomer(customerId);
            if (customer == null) {
                return "Customer not found";
            }

            bank.addAccount(customer, iban, balance);
            return "Created bank account with IBAN " + iban.toString();
        } catch (NumberFormatException e) {
            return "Could not parse numeric input variables";
        } catch (InvalidIbanException e) {
            return "Could not parse the given IBAN";
        }
    }

    public static String getBalance(Bank bank, String[] words) {
        if (words.length != 2) {
            return "Usage: balance IBAN";
        }
        try {
            Iban iban = Iban.parseIban(words[1]);
            double balance = bank.getBalance(iban);
            return String.format("%s has a balance of €%.02f", iban.toString(), balance);
        } catch (InvalidIbanException e) {
            return "Could not parse the given IBAN";
        } catch (UnknownBankAccountException e) {
            return "No bank account with given IBAN";
        }
    }

    public static String getAccounts(Bank bank, String[] words) {
        if (words.length != 2) {
            return "Usage: getAccounts customerId";
        }
        try {
            int customerId = Integer.parseInt(words[1]);
            Customer customer = bank.getCustomer(customerId);
            if(customer == null) {
                return "Customer not found";
            } else {
                List<Iban> ibans = bank.getBankAccountsByCustomer(customer);
                if(ibans.size() > 0) {
                    return "- " + ibans.stream().map(Iban::toString).collect(Collectors.joining("\n- "));
                }
                return "No bank accounts found for " + customer.getFullName();
            }
        } catch (NumberFormatException e) {
            return "Could not parse customer ID";
        }
    }
}
