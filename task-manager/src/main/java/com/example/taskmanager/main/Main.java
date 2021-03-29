package com.example.taskmanager.main;

import com.example.taskmanager.cli.TaskManagerTerminalImpl;
import com.example.taskmanager.exceptions.CLIException;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new TaskModule());
        try {
            TaskManagerTerminalImpl taskManagerCLI = injector.getInstance(TaskManagerTerminalImpl.class);
            taskManagerCLI.runTerminal();
        } catch (CLIException e) {
            System.err.println("Failed to create JLine CLI: " + e.getMessage());
        }
    }
}
