package com.example.java.overig;

public class TryResources {

    private void noCatching() {
        try (MyRunner myRunner = new MyRunner()) {
            System.out.println("Running");
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting");
        try (MyRunner myRunner = new MyRunner()) {
            System.out.println("Running");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Catching");
        } finally {
            System.out.println("Finalizing");
        }
    }

    private static class MyRunner implements AutoCloseable {
        @Override
        public void close() {
            System.out.println("Closing");
        }
    }
}
