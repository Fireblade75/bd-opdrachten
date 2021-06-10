package com.example.java.lambda;

import java.util.Optional;
import java.util.Random;

public class OptionalSystem {

    public static void main(String[] args) {
        Random random = new Random();
        int sum = random.ints(0, 120)
                .limit(100)
                .mapToObj(i -> i > 100 ? Optional.<Integer>empty() : Optional.of(i))
                .filter(Optional::isPresent)
                .mapToInt(Optional::get)
                .sum();
        System.out.println(sum);
    }

}
