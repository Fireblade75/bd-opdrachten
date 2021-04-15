package com.example.java.overig.streamtests;

import java.util.Random;
import java.util.concurrent.Callable;

public class PuzzleSolver implements Callable<PuzzleSolver.Vector2> {

    private final SimplePuzzle puzzle;

    public PuzzleSolver(SimplePuzzle simplePuzzle) {
        this.puzzle = simplePuzzle;
    }

    @Override
    public Vector2 call() {
        Random random = new Random();
        Vector2 solution;
        while (true) {
            int x = random.nextInt(SimplePuzzle.MAX_BOUND - SimplePuzzle.MIN_BOUND) + SimplePuzzle.MIN_BOUND;
            int y = random.nextInt(SimplePuzzle.MAX_BOUND - SimplePuzzle.MIN_BOUND) + SimplePuzzle.MIN_BOUND;
            synchronized (this) {
                if (puzzle.solve(x, y)) {
                    solution = new Vector2(x, y);
                    break;
                }
            }
        }
        return solution;
    }

    public static final class Vector2 {
        public final int x;
        public final int y;

        private Vector2(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
