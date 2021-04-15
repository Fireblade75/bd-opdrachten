package com.example.java.lambda;

import java.util.Arrays;
import java.util.List;

public class Eq {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);
        double first = list.stream().mapToInt(x->x).sum();

        double second = list.stream().reduce(0, (a, b) -> a+b);
        System.out.println(first);
        System.out.println(second);
    }
}
