package com.example.taskmanager.exceptions;

public class CLIException extends RuntimeException {
    private static final long serialVersionUID = 4907478156085355263L;

    public CLIException(String message) {
        super(message);
    }
}
