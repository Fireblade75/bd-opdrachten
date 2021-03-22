package com.example.h6;

import java.util.Arrays;
import java.util.Scanner;

public class NumberScanner {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            var intArr = new int[10];
            for (int i = 0; i < 10; i++) {
                intArr[i] = Integer.parseInt(scanner.nextLine());
            }
            System.out.println(Arrays.toString(intArr));
        } catch (NumberFormatException e) {
            System.out.println("Could not parse number");
        }
    }
}
