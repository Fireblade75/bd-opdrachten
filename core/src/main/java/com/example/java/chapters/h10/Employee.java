package com.example.java.chapters.h10;

public class Employee extends Person{
    public Employee(String name) {
        super(name);
    }

    @Override
    public String getGreeting() {
        return "I'm tired of working. This is inhuman!.";
    }
}
