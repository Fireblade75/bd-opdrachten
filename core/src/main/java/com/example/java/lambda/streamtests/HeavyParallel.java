package com.example.java.lambda.streamtests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class HeavyParallel {

    static private boolean isPrime(int value) {
        if(value <= 3) return value > 1;

        if((value % 2 == 0) || (value % 3 == 0)) return false;

        int i = 5;
        while (i << 2 <= value) {
            if (((value % i) == 0) || (value % (i + 2) == 0)) return false;
            i += 6;
        }
        return true;
    }

    private static List<Integer> findPrimeNumbersInValue(int value) {
        List<Integer> result = new ArrayList<>();
        if(value <= 1) {
            return result;
        }

        for (int i = value; i > 0; i--) {
            if(isPrime(i)) {
                value -= i;
                result.add(i);
            }
        }
        return result;
    }

    public static long executeFunction(int limit, boolean shouldPrint, boolean parallel) {
        Stream<Integer> intStream = Stream.generate(new IntegerIterator(0)).limit(limit);

        if(parallel) {
            intStream = intStream.parallel();
        }

        long startTime = System.nanoTime();
        intStream
                .map(HeavyParallel::findPrimeNumbersInValue)
                .forEach((result) -> {
                    if(shouldPrint) {
                        System.out.println(result);
                    }
                });
        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    public static void main(String[] args) {
        final int complexity = 5000;
        final int tries = 10;


        LongStream.generate(() -> executeFunction(complexity, false, false))
                .limit(tries)
                .average()
                .ifPresent((averageNanoTime ->
                        System.out.printf("It took %d ns on average to execute the method iterative%n", (long) averageNanoTime)));

        LongStream.generate(() -> executeFunction(complexity, false, true))
                .limit(tries)
                .average()
                .ifPresent((averageNanoTime ->
                        System.out.printf("It took %d ns on average to execute the method in parallel%n", (long) averageNanoTime)));
    }
}
