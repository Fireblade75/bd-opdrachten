package com.example.h10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AndroidTest {

    Android android = new Android();

    @Test
    void greet() {
        android.greet();
    }

    @Test
    void charge() {
        android.charge(30);
        android.greet();
        assertThrows(Android.OverchargedException.class, () -> {
           android.charge(90);
        });
    }
}