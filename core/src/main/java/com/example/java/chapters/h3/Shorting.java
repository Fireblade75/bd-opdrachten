package com.example.java.chapters.h3;

public class Shorting {

    public static void main(String[] args) {

        int too_long_a = 0b111_01100111;
        int fitting_a = 0b000_01100111;

        System.out.printf("%s is equal to %s%n", (byte) fitting_a, (byte) too_long_a);

        int too_long_b = 0b111_11100111;
        int fitting_b = 0b000_11100111;

        System.out.printf("%s is equal to %s%n", (byte) fitting_b, (byte) too_long_b);
    }
}
