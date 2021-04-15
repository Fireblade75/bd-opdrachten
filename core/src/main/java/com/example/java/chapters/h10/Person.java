package com.example.java.chapters.h10;

public class Person extends Human {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String getGreeting() {
        return String.format("Hello, my name is %s. Nice to meet you!", name);
    }

    @Override
    public String toString() {
        return name;
    }
}
