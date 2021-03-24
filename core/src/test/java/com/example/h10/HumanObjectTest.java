package com.example.h10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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