package com.example.h12;

import com.example.h10.Human;

@MyAnnotation
public class Person extends Human {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @MyAnnotation2
    @Override
    public void greet() {
        System.out.printf("Hello, my name is %s. Nice to meet you!%n", name);
    }
}
