package com.example.injection.diproject.services;

import com.example.injection.di.Inject;
import com.example.injection.diproject.services.logger.BasicLogger;

public class AdderImpl implements Adder {

    @Inject
    private Parser parser;

    @Inject
    private BasicLogger logger;

    @Override
    public int add(String val1, String val2) {
        logger.info(getClass(), "Value 1: " + val1);
        logger.info(getClass(), "Value 2: " + val2);
        return parser.parse(val1) + parser.parse(val2);
    }
}
