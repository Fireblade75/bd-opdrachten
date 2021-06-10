package com.example.injection.diproject.services;

import com.example.injection.di.Inject;
import com.example.injection.diproject.services.logger.BasicLogger;

import java.util.Random;

public class RandomTimeWriter {

    public static final int MAX_MINUTES = 60;
    public static final int MAX_SECOND = 60;

    @Inject
    private Random random;

    @Inject
    private BasicLogger logger;

    public void writeToConsole(Object line) {
        int minutes = random.nextInt(MAX_MINUTES);
        int seconds = random.nextInt(MAX_SECOND);

        String logLine = String.format("[%02d:%02d] %s", minutes, seconds, line.toString());
        logger.info(getClass(), logLine);
    }
}
