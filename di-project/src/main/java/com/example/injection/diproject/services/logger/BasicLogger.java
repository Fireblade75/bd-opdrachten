package com.example.injection.diproject.services.logger;

public interface BasicLogger {
    void info(Class<?> source, String line);

    void error(Class<?> source, String line);
}
