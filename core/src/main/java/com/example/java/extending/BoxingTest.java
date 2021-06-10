package com.example.java.extending;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class BoxingTest {

    static void takeLong(long... longs) {
        Arrays.stream(longs).forEach(l -> {
            System.out.printf("%d", l);
        });
    }

    static void takeLong(Long l) {
        System.out.printf("%d", l);
    }

    static void takeFloat(Float f) {
        System.out.printf("%.02f", f);
    }

    public static void main(String[] args) {
        int i = 4;
        takeLong(i);

        Integer integer = 4;
        takeLong(integer);

        Double half = 0.5;
        takeFloat(half.floatValue());
    }

    void unboxingStream() {
        List<Integer> boxedInts = List.of(1, 2, 3, 4, 5);
        OptionalDouble res = boxedInts.stream().mapToInt(Integer::intValue).average();
        if(res.isPresent()) {
            System.out.println(res.getAsDouble());
        }
        Optional<Integer> x = boxedInts.stream().reduce((prev, cur) -> prev - cur);
    }
}
