package com.example.diproject.services;

public class ParserImpl implements Parser {
    @Override
    public int parse(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
