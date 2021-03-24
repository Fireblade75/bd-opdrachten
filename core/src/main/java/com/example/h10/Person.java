package com.example.h10;

public class Person extends Human {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void greet() {
        System.out.printf("Hello, my name is %s. Nice to meet you!%n", name);
    }
}
