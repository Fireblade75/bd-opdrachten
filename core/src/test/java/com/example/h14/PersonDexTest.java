package com.example.h14;

import com.example.h7.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonDexTest {

    private PersonDex personDex;

    @BeforeEach
    void setup() {
        personDex = new PersonDex();
    }

    @Test
    void testDuplicates() {
        Person kim1 = new Person("Kim", 21);
        Person kim2 = new Person("Kim", 20);
        Person kim3 = new Person("Kim", 21);
        personDex.addPerson(kim1);
        personDex.addPerson(kim2);
        personDex.addPerson(kim3);

        assertTrue(personDex.contains(kim1));
        assertTrue(personDex.contains(kim2));
        assertTrue(personDex.contains(kim3));
        assertEquals(2, personDex.size());
    }

    @Test
    void testInsertion() {
        Person bob = new Person("Bob", 14);
        Person kim1 = new Person("Kim", 20);
        Person kim2 = new Person("Kim", 21);
        assertFalse(personDex.contains(bob));
        personDex.addPerson(bob);
        personDex.addPerson(kim1);
        assertTrue(personDex.contains(bob));
        assertTrue(personDex.contains(kim1));
        assertFalse(personDex.contains(kim2));
        assertEquals(2, personDex.size());
    }
}