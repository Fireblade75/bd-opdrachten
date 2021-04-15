package com.example.java.chapters.h10;

import org.junit.jupiter.api.Test;

class HumanObjectTest {

    @Test
    void testGreetings() {
        Human person = new Person("Kyle");
        Human teacher = new Teacher("Kim");
        Human employee = new Employee("Caroline");

        person.greet();
        teacher.greet();
        employee.greet();
    }
}