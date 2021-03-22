package com.example.h6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class ArraysTest {

    void o1() {
        long[] row = new long[4];
        row[2] = 3;
        long[] copy = row;
        copy[2]++;

        System.out.printf("row[2] = %d%n", row[2]);
        try {
            System.out.printf("row[4] = %d%n", row[4]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    long[] doubleArray(long[] arr) {
        long[] res = new long[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    long[] doubleArrayAlt(long[] arr) {
        long[] res = new long[arr.length * 2];
        System.arraycopy(arr, 0, res, 0, arr.length);
        return res;
    }

    long[] multiply(long[] input, int multiplier) {
        for (int i = 0; i < input.length; i++) {
            input[i] *= multiplier;
        }
        return input;
    }

    long[] fib(int n) {
        if (n < 0 || n > 94) {
            throw new RuntimeException("n should be between 0 and 94");
        }
        long[] result = new long[n];
        if (n > 0) {
            result[0] = 1;
        }
        if (n > 1) {
            result[1] = 1;
        }
        if (n > 2) {
            for (int i = 2; i < n; i++) {
                result[i] = result[(i - 2)] + result[(i - 1)];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        ArraysTest arraysTest = new ArraysTest();
        arraysTest.o1();

        long[] resArr = arraysTest.doubleArray(new long[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(resArr));

        arraysTest.multiply(resArr, 2);
        System.out.println(Arrays.toString(resArr));

        System.out.println(Arrays.toString(arraysTest.fib(10)));

    }
}
