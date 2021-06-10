package com.example.injection.diproject.services.logger;

public class MyLogger implements BasicLogger {

    private final String project;

    public MyLogger(String project) {
        this.project = project;
    }

    @Override
    public void info(Class<?> source, String line) {
        System.out.printf("INFO [%s:%s] %s%n", project, source.getSimpleName(), line);
    }

    @Override
    public void error(Class<?> source, String line) {
        System.out.printf("ERROR [%s:%s] %s%n", project, source.getSimpleName(), line);
    }
}
