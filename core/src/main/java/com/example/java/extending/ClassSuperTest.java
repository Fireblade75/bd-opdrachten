package com.example.java.extending;

public class ClassSuperTest {

    private class A {
        private String name;

        public A() {
            this.name = "unknown";
        }

        public A(String name) {
            this.name = name;
        }
    }

    private class B extends A {
        private int size;

        public B(String name, int size) {
            super(name);
        }

        public B(String name) {
            this(name, 1);
        }
    }

}
