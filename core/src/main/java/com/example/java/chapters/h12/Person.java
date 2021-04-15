package com.example.java.chapters.h12;

import com.example.java.chapters.h10.Human;

@MyAnnotation
public class Person extends Human {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @MyAnnotation2
    @Override
    public String getGreeting() {
        return String.format("Hello, my name is %s. Nice to meet you!%n", name);
    }
}
