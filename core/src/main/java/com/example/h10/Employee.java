package com.example.h10;

public class Employee extends Person{
    public Employee(String name) {
        super(name);
    }

    @Override
    public void greet() {
        System.out.println("I'm tired of working. This is inhuman!.");
    }
}
