package com.example.java.chapters.h12.lc;

import java.util.List;

public class Tester {
    public static void main(String[] args) {
        PersonFactory factory = new PersonFactory();
        List<PersonFactory.Humanoid> humanoidList = List.of(
                factory.makeHuman("A"),
                factory.makeRobot("B"),
                factory.makeRobot("C"),
                factory.makeHuman("D"),
                factory.makeRobot("E")
        );

        for (PersonFactory.Humanoid humanoid : humanoidList) {
            if(humanoid.getClass().isAnnotationPresent(Person.class)) {
                System.out.println(humanoid);
            }
        }

    }
}
