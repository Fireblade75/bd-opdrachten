package com.example.h13;

import java.util.List;

public class FinalExtends {

    void printRabbits(List<? extends Rabbit> rabbits) {
        // rabbits.add(new Rabbit("brown"));
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
