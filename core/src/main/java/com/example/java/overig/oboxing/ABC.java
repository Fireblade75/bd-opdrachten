package com.example.java.overig.oboxing;

public class ABC {
    class A {
        private int i = 10;
    }

    class B extends A {
        public int i = 20;
    }

    void run() {
        B b = new B();
        A a = b;
        System.out.println(b.i);
        System.out.println(a.i);
    }

    public static void main(String[] args) {
        new ABC().run();


    }
}
