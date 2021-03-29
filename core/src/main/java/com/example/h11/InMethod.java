package com.example.h11;

import java.util.function.Function;

public class InMethod {

    public Object getHorse() {
        class Horse {
            public final int legCount = 4;
        }
        return new Horse();
    }

    void useCounter() {
        count(new Counter() {
            @Override
            public int count(String word) {
                return word.length();
            }
        });
        count(word -> word.length());
        count(String::length);
    }

    static void count(Counter counter) {
        Function<Integer,Double> log4 = i -> Math.log(i) / Math.log(4);
        var res = log4.apply(counter.count("thing"));
        System.out.println(res);
    }


    @FunctionalInterface
    interface Counter {
        int count(String word);
    }
}
