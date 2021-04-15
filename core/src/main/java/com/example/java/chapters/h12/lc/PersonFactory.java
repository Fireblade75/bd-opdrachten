package com.example.java.chapters.h12.lc;

public class PersonFactory {

    public Humanoid makeHuman(String name) {
        return new Human(name);
    }

    public Humanoid makeRobot(String name) {
        return new Robot(name);
    }

    public static abstract class Humanoid {
        private final String name;

        public String getName() {
            return name;
        }

        Humanoid(String name) {
            this.name = name;
        }
    }

    private static class Robot extends Humanoid {

        Robot(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Robot " + getName();
        }
    }

    @Person
    private static class Human extends Humanoid {

        Human(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Human " + getName();
        }
    }
}