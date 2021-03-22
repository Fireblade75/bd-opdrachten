package com.example.h5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FiboTest {

    @Test
    void goldenRatio() {
        Fibo fibo = new Fibo();
        double goldenRatio = fibo.goldenRatio(92);
        assertEquals(goldenRatio, 1.617, 0.002);
    }
}