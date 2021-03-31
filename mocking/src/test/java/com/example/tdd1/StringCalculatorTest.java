package com.example.tdd1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setup() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void testNullString() {
        assertThatCode(() -> stringCalculator.add(null))
                .isInstanceOf(InvalidInputStringException.class)
                .hasMessage("Input is null");
    }

    @Test
    public void testEmptyString() {
        assertThat(stringCalculator.add("")).isEqualTo(0);
    }

    @Test
    public void testBasicString() {
        assertThat(stringCalculator.add("4")).isEqualTo(4);
        assertEquals(4, stringCalculator.add("4"));
        assertEquals(6, stringCalculator.add("42"));
        assertEquals(15, stringCalculator.add("483"));
    }
}