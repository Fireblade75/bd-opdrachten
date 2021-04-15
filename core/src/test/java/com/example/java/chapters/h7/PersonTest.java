package com.example.java.chapters.h7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testPerson() {
        Person p = new Person("Jan", 45);
        assertEquals(p.getGender(), Gender.UNKNOWN);
        p.setGender(Gender.MALE);
        assertEquals(p.getGender(), Gender.MALE);
        p.haveBirthday(); // person gets one year older
        System.out.println(p.getAge());
        assertEquals(p.getAge(), 46);
        assertEquals(Person.numberOfPossibleGenders, 3);
    }

    @Test
    void testOverrides() {
        Person p1 = new Person("Jan", 45);
        Person p2 = new Person("Jan", 45);
        Person p3 = new Person("Kim", 30);

        assertEquals(p1, p2);
        assertNotEquals(p1, p3);
        assertEquals(p1.hashCode(), p2.hashCode());
        assertNotEquals(p1.hashCode(), p3.hashCode());

        p2.setGender(Gender.FEMALE);
        assertNotEquals(p1, p2);
        assertNotEquals(p1.hashCode(), p2.hashCode());

        assertEquals(p1.toString(), "Jan (45) is UNKNOWN");
        assertEquals(p2.toString(), "Jan (45) is FEMALE");
    }

    @Test
    void testConstructorOverride() {
        Person p = new Person("Jane", 30, Gender.FEMALE);
        assertEquals(p.toString(), "Jane (30) is FEMALE");
    }
}