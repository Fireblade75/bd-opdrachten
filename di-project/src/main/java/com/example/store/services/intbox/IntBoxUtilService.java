package com.example.store.services.intbox;

public class IntBoxUtilService {

    public int getInt(IntBox intBox) {
        return intBox.getInteger();
    }

    public String toString(IntBox intBox) {
        return intBox.getInteger().toString();
    }

    public boolean equals(IntBox first, IntBox second) {
        return first.getInteger().equals(second.getInteger());
    }

    public IntBox build(int result) {
        return new IntBox(result);
    }
}
