package com.example.datareader;

public class LineError extends Exception {
    public LineError(String line) {
        super("Err on line: " + line);
    }
}
