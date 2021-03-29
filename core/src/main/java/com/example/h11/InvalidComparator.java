package com.example.h11;

import java.util.Comparator;
import java.util.List;

public class InvalidComparator {
    public static void main(String[] args) {
        List<Integer> numbers = new java.util.ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));


        numbers.sort(new Comparator<>() {
            boolean flipper = true;

            @Override
            public int compare(Integer o1, Integer o2) {
                flipper = !flipper;
                return flipper ? 1 : -1;
            }
        });

        System.out.println(numbers);
    }
}
