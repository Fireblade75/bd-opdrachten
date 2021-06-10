package com.example.java.overig.oboxing;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class MyBox<T> {
    private T value;


    public MyBox(@NotNull T value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public MyBox(@NotNull Boxable<T> boxable) {
        Objects.requireNonNull(boxable);

        T value  = boxable.getValue();
        Objects.requireNonNull(value);
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(@NotNull T value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyBox<?> myBox = (MyBox<?>) o;
        return value.equals(myBox.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "[" + value + "]";
    }
}
