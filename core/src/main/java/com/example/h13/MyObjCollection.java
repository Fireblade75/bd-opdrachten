package com.example.h13;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MyObjCollection<T> implements Collection<T>, Iterable<T> {
    private int maxArrSize = 4;
    private T[] valueArr = (T[]) new Object[maxArrSize];
    private int length = 0;

    public boolean add(T value) {
        if(length == maxArrSize) {
            maxArrSize *= 2;
            valueArr = Arrays.copyOf(valueArr, maxArrSize*2);
        }
        valueArr[length++] = value;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < length; i++) {
            if(valueArr.equals(o)) {
                if(i == length -1) {
                    valueArr[i] = null;
                } else {
                    valueArr[i] = valueArr[length - 1];
                    valueArr[length - 1] = null;
                }
                length--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < length; i++) {
            valueArr[i] = null;
        }
        length = 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < length; i++) {
            if(valueArr[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(valueArr, length));
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new MyObjCollIterator();
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(valueArr, length);
    }

    @NotNull
    @Override
    public <T1> T1[] toArray(@NotNull T1[] a) {
        return null;
    }

    private class MyObjCollIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < length;
        }

        @Override
        public T next() {
            return valueArr[index++];
        }
    }
}
