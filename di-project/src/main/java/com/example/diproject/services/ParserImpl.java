package com.example.diproject.services;

import com.example.di.Inject;
import com.example.diproject.services.logger.BasicLogger;
import com.example.diproject.services.logger.MyLogger;

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
