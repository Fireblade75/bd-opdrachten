package com.example.java.lambda;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AppleCrate {

    List<Apple> content = new ArrayList<>();

    public void addApple(Apple... apples) {
        content.addAll(Arrays.asList(apples));
    }

    public void addApples(List<Apple> apples) {
        content.addAll(apples);
    }

    public static AppleCrate boxApples(List<Apple> apples) {
        return apples.stream().collect(
                AppleCrate::new,
                AppleCrate::addApple,
                (crate1, crate2) -> crate1.addApples(crate2.content)
        );
    }

    public static void main(String[] args) {
        AppleService appleService = new AppleService();
        System.out.println(boxApples(appleService.getRandomApples(5)));
    }

    @Override
    public String toString() {
        return "AppleCrate{" +
                "content=" + content +
                '}';
    }

    public int getWeight() {
        return content.stream().collect(Collectors.summingInt(Apple::getWeight));
    }

    public Integer getWeightAlt() {
        return content.stream().collect(new Collector<Apple, BoxedInt, Integer>() {

            @Override
            public Supplier<BoxedInt> supplier() {
                return BoxedInt::new;
            }

            @Override
            public BiConsumer<BoxedInt, Apple> accumulator() {
                return (boxedInt, apple) -> boxedInt.set(boxedInt.intValue() + apple.getWeight());
            }

            @Override
            public BinaryOperator<BoxedInt> combiner() {
                return (a, b) -> {
                    a.set(a.intValue() + b.intValue());
                    return a;
                };
            }

            @Override
            public Function<BoxedInt, Integer> finisher() {
                return BoxedInt::intValue;
            }

            @Override
            public Set<Characteristics> characteristics() {
                return EnumSet.of(Characteristics.CONCURRENT);
            }
        });
    }

    private static class BoxedInt {
        private int value;

        private BoxedInt() {
            this.value = 0;
        }

        private BoxedInt(int value) {
            this.value = value;
        }

        public int intValue() {
            return value;
        }

        public void set(int value) {
            this.value = value;
        }
    }
}
