package com.example.java.chapters.h13;

import java.util.List;

public class FinalExtends {

    void printRabbits(List<? extends Rabbit> rabbits) {
        // rabbits.add(new Rabbit("brown"));
        String k = "";
        k.intern();
    }


    private static final class Rabbit {
        private final String color;

        public Rabbit(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return color + " rabbit";
        }
    }
}
