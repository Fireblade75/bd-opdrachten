package com.example.java.overig;

import java.util.HashSet;
import java.util.Objects;

public class EqualsTest {
    private static class BoxedInt {
        private int boxedInt;

        public BoxedInt(int value) {
            boxedInt = value;
        }

        public boolean equals(BoxedInt boxedInt) {
            return this.boxedInt == boxedInt.boxedInt;
        }

        @Override
        public boolean equals(Object o) {
            if(!(o instanceof BoxedInt)) return false;
            return boxedInt == ((BoxedInt) o).boxedInt;
        }

        @Override
        public int hashCode() {
            return Objects.hash(Integer.hashCode(boxedInt));
        }

        @Override
        public String toString() {
            return "[" + boxedInt + "]";
        }
    }

    public static void main(String[] args) {
        HashSet<BoxedInt> boxedInts = new HashSet<>();
        boxedInts.add(new BoxedInt(1));
        boxedInts.add(new BoxedInt(12));
        boxedInts.add(new BoxedInt(1));
        System.out.println(boxedInts);
    }
}
