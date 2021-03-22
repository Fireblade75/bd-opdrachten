package com.example.bankapp.cli;

import com.example.bankapp.Bank;

public class CommandHandler {
    Bank bank = new Bank();

    public String handleCommand(String line) {
        String[] words = line.split(" ");
        if (words.length == 0) {
            return "";
        }

        switch (words[0]) {
            case "exit":
                return "exit";
            case "createCustomer":
                return CustomerCommands.createCustomer(bank, words);
            case "getCustomer":
                return CustomerCommands.getCustomer(bank, words);
            case "createAccount":
                return BankAccountCommands.createNewAccount(bank, words);
            case "transfer":
                return BankAccountCommands.transfer(bank, words);
            case "balance":
                return BankAccountCommands.getBalance(bank, words);
            case "getAccounts":
                return BankAccountCommands.getAccounts(bank, words);
            default:
                return "Unknown command";
        }
    }



}
