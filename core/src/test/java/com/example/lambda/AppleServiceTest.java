package com.example.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AppleServiceTest {

    AppleService appleService = new AppleService();

    @Test
    public void shouldPrintApples() {
        List<Apple> apples = appleService.getRandomApples(10);
        appleService.shouldPrintApples(apples);
    }

    @Test
    void testShouldPrintApples() {
    }

    @Test
    void removeWeightFromApples() {
        List<Apple> appleList = List.of(
                new Apple(Apple.RED, 3),
                new Apple(Apple.GREEN, 2),
                new Apple(Apple.RED, 8)
        );
        appleService.removeWeightFromApples(appleList);
        assertEquals(0, appleService.getTotalWeight(appleList));
    }

    @Test
    void getApplesOfColor() {
        List<Apple> partialRedAppleList = List.of(
                new Apple(Apple.RED, 3),
                new Apple(Apple.GREEN, 2),
                new Apple(Apple.RED, 8)
        );
        List<Apple> result = appleService.getApplesOfColor(partialRedAppleList, Apple.RED);
        assertEquals(2, result.size());
    }

    @Test
    void getNoApplesOfColor() {
        List<Apple> noAppleList = new ArrayList<>();
        List<Apple> result = appleService.getApplesOfColor(noAppleList, Apple.RED);
        assertEquals(0, result.size());
    }

    @Test
    void supplyApple() {
        Optional<Apple> existingApple = Optional.of(new Apple(Apple.RED, 2));
        Optional<Apple> emptyApple = Optional.empty();

        Apple existingAppleRes = appleService.supplyApple(existingApple);
        assertEquals(Apple.RED, existingAppleRes.getColor());
        assertEquals(2, existingAppleRes.getWeight());

        assertNotNull(appleService.supplyApple(emptyApple));
    }
}