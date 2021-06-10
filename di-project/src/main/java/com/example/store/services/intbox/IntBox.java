package com.example.store.services.intbox;

public class IntBox {
    private final Integer integer;

    protected IntBox(int i) {
        this.integer = i;
    }

    protected Integer getInteger() {
        return integer;
    }
}
