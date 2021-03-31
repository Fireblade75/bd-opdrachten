package com.example.h7;

import java.util.Objects;

public class Person {
    public static int numberOfPossibleGenders = Gender.values().length;
    private static int MAX_AGE = 130;

    private String name;
    private int age;
    private Gender gender = Gender.UNKNOWN;

    public Person(String name, int age, Gender gender) {
        this(name, age);
        this.gender = gender;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void haveBirthday() {
        if(age == MAX_AGE) {
            throw new PersonDiedException();
        }
        age++;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Person)) return false;
        Person p = (Person) o;
        return name.equals(p.name) && age == p.age && gender == p.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.hashCode(), Integer.hashCode(age), gender.hashCode());
    }

    @Override
    public String toString() {
        return String.format("%s (%d) is %s", name, age, gender);
    }
}
