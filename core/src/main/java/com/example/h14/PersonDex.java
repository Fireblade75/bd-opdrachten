package com.example.h14;

import com.example.h7.Person;

import java.util.HashSet;

public class PersonDex {
    private final HashSet<Person> peopleSet = new HashSet<>();

    public void addPerson(Person person) {
        peopleSet.add(person);
    }

    public int size() {
        return peopleSet.size();
    }

    public boolean contains(Person person) {
        return peopleSet.contains(person);
    }
}
