package com.example.h5;

import java.util.ArrayList;
import java.util.List;

public class RefTest {

    void increment(Integer j, Person person) {
        person.setName("Kim");
        person = person.overrideName("Lenard");
        j = 10;
        j = Integer.valueOf(j.intValue() + 1);
        j = j++;
        System.out.println(j);
    }


    public static void main(String[] args) {
        RefTest refTest = new RefTest();
        Integer k = 6;
        Person person = new Person("Bob");
        refTest.increment(k, person);
        System.out.println(k);
        System.out.println(person.getName());
    }


    public static class Person {
        private String name;
        final List<String> strings = new ArrayList<>();


        Person(String name) {
            this.name = name;

            // Integer@0000 null 0b0000_0000_0000_0000_0000_0000_0000_0000
            Integer integer;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Person overrideName(String name) {
            return new Person(name);
        }
    }
}

/*
 * k: @2348 -> 6
 * j: @2348 -> 6
 * j: @2349 -> 7
 *
 * interger: @2350 -> 55
 * final ArrayList: @2351 -> { 1, 2, 3 }
 * final ArrayList: @2351 -> { 1, 2, 4 }
 */