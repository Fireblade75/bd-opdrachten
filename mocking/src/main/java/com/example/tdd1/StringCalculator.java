package com.example.tdd1;

import java.util.regex.Pattern;

public class StringCalculator {
    Pattern numbersPattern = Pattern.compile("\\d{0,3}");

    public int add(String numbers) {
        if(numbers == null) {
            throw new InvalidInputStringException("Input is null");
        }
        var matcher = numbersPattern.matcher(numbers);
        if(!matcher.matches()) {
            throw new RuntimeException();
        } else {
            int result = 0;
            for (int i = 0; i < numbers.length(); i++) {
                result += Integer.parseInt(String.valueOf(numbers.charAt(i)));
            }
            return result;
        }
    }
}
