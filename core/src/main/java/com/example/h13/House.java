package com.example.h13;

import com.example.h10.Person;

public class House<T extends Person> {

    private final T person;

    public House(T person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return String.format("This house is owned by [%s] and it says [%s].", person.toString(), person.getGreeting());
    }
}
