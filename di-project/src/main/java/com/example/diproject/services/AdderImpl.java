package com.example.diproject.services;

import com.example.di.Inject;

public class AdderImpl implements Adder {

    @Inject
    private ParserImpl parser;

    @Override
    public int add(String val1, String val2) {
        return parser.parse(val1) + parser.parse(val2);
    }
}
