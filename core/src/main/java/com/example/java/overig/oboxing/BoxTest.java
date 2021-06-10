package com.example.java.overig.oboxing;

public class BoxTest {

    private static Boxable<Integer> addBoxes(Boxable<Integer> a, Boxable<Integer> b) {
        return () -> a.getValue() + b.getValue();
    }

    private static <T> MyBox<T> wrap(Boxable<T> boxable) {
        return new MyBox<>(boxable);
    }


    public static void main(String[] args) {
        var res = addBoxes(() -> 4, () -> 8);
        System.out.println(wrap(res));
        System.out.println(res.getClass().getName());
        System.out.println(wrap(() -> Math.E));
    }
}
