package com.example.java.lambda.streamtests;

import java.util.function.Supplier;

public class IntegerIterator implements Supplier<Integer> {

    private int index;

    public IntegerIterator() {
       this(0);
    }

    public IntegerIterator(int start) {
        this.index = start;
    }

    @Override
    public Integer get() {
        if(index == Integer.MAX_VALUE) {
            throw new IntegerOverflowException();
        }
        return index++;
    }

    private static class IntegerOverflowException extends RuntimeException {
        private static final long serialVersionUID = 6933942428705997281L;
    }
}
