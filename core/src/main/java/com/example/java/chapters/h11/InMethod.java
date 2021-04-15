package com.example.java.chapters.h11;

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
        count(word -> {
                // do soemthing
                return word.length();
            }
        );
        count(word -> word.length());
        count(String::length);

        Function<String, Integer> getSize = s -> s.length();
    }

    static void count(Counter counter) {
        Function<Integer,Double> log4 = i -> Math.log(i) / Math.log(4);
        System.out.println(counter.count("Bob!"));
    }


    @FunctionalInterface
    interface Counter {
        int count(String word);
    }
}
