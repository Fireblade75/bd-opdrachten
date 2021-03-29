package com.example.taskmanager.exceptions;

public class TaskNotFoundException extends Exception {
    private static final long serialVersionUID = -964621174616914533L;

    public TaskNotFoundException() {

    }

    public TaskNotFoundException(String message) {
        super(message);
    }
}
