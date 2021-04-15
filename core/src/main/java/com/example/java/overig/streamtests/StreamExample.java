package com.example.java.overig.streamtests;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StreamExample {

    Random r = new Random();

    Supplier<Integer> intSupplier = () -> r.nextInt(10);
    Predicate<Integer> intFilter = v -> v < 5;
    UnaryOperator<Integer> intDoubler = v -> v*2;
    Consumer<Integer> intPrinter = System.out::println;

    public void printRandomIntSum() {

        int sum = Stream.generate(intSupplier)
                .limit(100)
                .filter(intFilter)
                .map(intDoubler)
                .mapToInt(Integer::intValue)
                .sum();

    }

    public void printRandomInts () {

        Stream.generate(intSupplier)
                .limit(100)
                .filter(intFilter)
                .map(intDoubler)
                .forEach(intPrinter);

    }

}
