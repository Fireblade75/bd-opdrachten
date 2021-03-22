package com.example.h5;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Fibo {
    long run(int n) {
        return run(1, n);
    }

    long run(long start, int n) {
        return run(start, start, n);
    }

    long run(long f1, long f2, int n) {
        var result = new LinkedList<Long>();
        if(n > 0) {
            result.add(f1);
        }
        if(n > 1) {
            result.add(f2);
        }
        if(n > 2) {
            for (int i = 2; i < n; i++) {
                result.add(result.get(i-2) + result.get(i-1));
            }
        }

        String resultStr = result.stream().map(Object::toString).collect(Collectors.joining(", "));
        System.out.println(resultStr);
        return result.getLast();
    }

    double goldenRatio(int n) {
        double goldenRatio = ((double) run(n)) / run(n-1);
        System.out.println("Golden Ratio: " + goldenRatio);
        return goldenRatio;
    }

    public static void main(String[] args) {
        Fibo fibo = new Fibo();
        fibo.run(6);
        fibo.run(4, 6);
        fibo.run(4,5, 6);
        fibo.goldenRatio(92);
        // BigInt
    }
}

