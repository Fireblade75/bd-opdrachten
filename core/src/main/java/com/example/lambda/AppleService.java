package com.example.lambda;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppleService {
    private Random random = new Random();

    private final Supplier<Apple> appleSupplier = () -> {
        String color =  random.nextBoolean() ? Apple.GREEN : Apple.RED;
        int weight = random.nextInt(5) + 1;
        return new Apple(color, weight);
    };

    public void consumeApples(List<Apple> apples, Consumer<Apple> appleConsumer) {
        apples.forEach(appleConsumer::accept);
    }

    public void shouldPrintApples(List<Apple> apples) {
        consumeApples(apples, apple -> System.out.println(apple.toString()));
    }

    public void removeWeightFromApples(List<Apple> apples) {
        consumeApples(apples, apple -> apple.setWeight(0));
    }

    public List<Apple> getApplesOfColor(List<Apple> apples, String color) {
        Predicate<Apple> filter = apple -> apple.getColor().equals(color);
        return apples.stream().filter(filter).collect(Collectors.toList());
    }

    public int getTotalWeight(List<Apple> apples) {
        return apples.stream().mapToInt(Apple::getWeight).sum();
    }

    public Apple supplyApple(@NotNull Optional<Apple> apple) {
        return apple.orElseGet(appleSupplier);
    }

    public List<Apple> getRandomApples(int size) {
        return Stream.generate(appleSupplier).limit(size).collect(Collectors.toList());
    }
}
