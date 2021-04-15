package com.example.java.chapters.h8;

import com.example.java.chapters.h7.Gender;
import com.example.java.chapters.h7.Person;

public class PersonExperiment {
    public static void main(String[] args) {
        Person person = new Person("Bert", 40);
        person.setGender(Gender.MALE);

        System.out.println("\nMethods:");
        for(var method : person.getClass().getMethods()) {
            System.out.println(method);
        }

        System.out.println("\n\nFields:");
        for(var field : person.getClass().getDeclaredFields()) {
            System.out.println(field);
        }
    }
}
