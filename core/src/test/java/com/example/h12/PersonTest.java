package com.example.h12;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testMyAnnotation1() {
        Person person = new Person("Bob");

        assertEquals(person.getClass().getAnnotations().length, 1);
        assertTrue(person.getClass().isAnnotationPresent(MyAnnotation.class));
    }

    @Test
    void testMyAnnotation2() {
        Person person = new Person("Bob");

        Arrays.stream(person.getClass().getMethods())
                .filter(method -> method.getName().equals("getGreeting"))
                .findFirst().ifPresentOrElse(greet -> {
                    assertEquals(greet.getAnnotations().length, 0);
                    assertFalse(greet.isAnnotationPresent(MyAnnotation2.class));
                },
                () -> {
                    fail("Greet method not preset");
                });
    }
}