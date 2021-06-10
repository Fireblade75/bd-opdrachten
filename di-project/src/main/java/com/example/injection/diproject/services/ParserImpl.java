package com.example.injection.diproject.services;

import com.example.injection.di.Inject;
import com.example.injection.diproject.services.logger.BasicLogger;

public class ParserImpl implements Parser {

    @Inject
    private BasicLogger logger;

    @Override
    public int parse(String value) {
        logger.info(getClass(), "Parsing " + value + " to an int");
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            logger.error(getClass(), value + " is not an int");
            return 0;
        }
    }
}
