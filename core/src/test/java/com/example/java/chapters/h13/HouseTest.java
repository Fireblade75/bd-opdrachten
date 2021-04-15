package com.example.java.chapters.h13;

import com.example.java.chapters.h10.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {

    @Test
    void testHouse() {
        House<Employee> employeeHouse = new House<Employee>(new Employee("Bob"));
        assertEquals("This house is owned by [Bob] and it says [I'm tired of working. This is inhuman!.].",
                employeeHouse.toString());
    }
}