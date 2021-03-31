package com.example.diproject.services;

import com.example.di.Inject;

import java.util.Random;

public class RandomTimeWriter {

    public static final int MAX_MINUTES = 60;
    public static final int MAX_SECOND = 60;

    @Inject
    private Random random;

    public void writeToConsole(Object line) {
        int minutes = random.nextInt(MAX_MINUTES);
        int seconds = random.nextInt(MAX_SECOND);

        System.out.printf("[%02d:%02d] %s%n", minutes, seconds, line.toString());
    }
}
