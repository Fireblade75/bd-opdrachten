package com.example.java.overig;

import java.util.function.Supplier;

public interface RunnableGenerator<T> extends Runnable, Supplier<T> {
    T supplyT();
}
