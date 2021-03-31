package com.example.tdd1;

public class InvalidInputStringException extends RuntimeException {
    public InvalidInputStringException(String s) {
        super(s);
    }
}
