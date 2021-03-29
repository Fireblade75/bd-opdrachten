package com.example.taskmanager.exceptions;

public class NoActiveUserException extends Exception {
    private static final long serialVersionUID = -4501638045186735284L;

    public NoActiveUserException() {
        super("Please first select a user");
    }
}
