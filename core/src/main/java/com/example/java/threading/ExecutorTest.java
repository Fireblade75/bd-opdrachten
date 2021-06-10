package com.example.java.threading;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ExecutorTest {

    public static final int THREAD_POOL_SIZE = 20;
    public static final int CALLABLE_COUNT = 1000;
    public static final boolean PRINT_PARALLEL = true;

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.nanoTime();
        performFullChainPrinting();
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println("Method execution took " + duration + " ns");
    }

    static void performPrinting() {
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

            List<Future<String>> results = executorService.invokeAll(Collections.nCopies(CALLABLE_COUNT, new MyPrinter()));

            var resultStream = PRINT_PARALLEL ? results.stream().parallel() : results.stream();
            resultStream.forEach(ExecutorTest::printFuture);

            executorService.shutdown();
        } catch (InterruptedException e) {
            System.err.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    static void performFullChainPrinting() {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        var callableStream = Collections.nCopies(CALLABLE_COUNT, new MyPrinter()).stream();
        if(PRINT_PARALLEL) {
            callableStream = callableStream.parallel();
        }

        callableStream.map(executorService::submit)
                .forEach(ExecutorTest::printFuture);

        executorService.shutdown();
    }

    private static void printFuture(Future<String> f) {
        try {
            System.out.println(f.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("error");
        }
    }

    private static class MyPrinter implements Callable<String> {

        @Override
        public String call() {
            Random random = new Random();
            return random.ints('a', 'z')
                    .limit(random.nextInt(32) + 32)
                    .collect(
                            StringBuilder::new,
                            StringBuilder::appendCodePoint,
                            (sb1, sb2) -> sb1.append(sb2.toString())
                    ).toString();
        }
    }
}
