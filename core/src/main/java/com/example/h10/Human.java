package com.example.h10;

public abstract class Human {
    public void greet() {
        System.out.println(getGreeting());
    };

    public abstract String getGreeting();
}
