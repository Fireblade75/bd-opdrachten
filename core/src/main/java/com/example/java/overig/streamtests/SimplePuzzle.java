package com.example.java.overig.streamtests;

import java.util.Random;
import java.util.function.Supplier;

public class SimplePuzzle {

    public static final int MIN_BOUND = 1;
    public static final int MAX_BOUND = 10;
    public static Supplier<SimplePuzzle> puzzleSupplier = SimplePuzzle::generate;
    private static Random random = new Random();
    private final int x;
    private final int y;

    public SimplePuzzle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean solve(int x, int y) {
        if(x < MIN_BOUND || x > MAX_BOUND || y < MIN_BOUND || y > MAX_BOUND) {
            throw new IndexOutOfBoundsException();
        }
        if(this.x == x && this.y == y) {
            return true;
        }
        return false;
    }

    public static SimplePuzzle generate() {
        int x = random.nextInt(MAX_BOUND - MIN_BOUND) + MIN_BOUND;
        int y = random.nextInt(MAX_BOUND - MIN_BOUND) + MIN_BOUND;
        return new SimplePuzzle(x, y);
    }

}
