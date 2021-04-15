package com.example.java.chapters.h9;

import java.util.Objects;

public class FinalizeTest {

    public void boxTest() {
        try {
            StringBox box = new StringBox("Apple");
            box = new StringBox("Pear");
            System.gc();
            Thread.sleep(3000);
            box = new StringBox("Shark");
            box = new StringBox("Salmon");
            box = new StringBox("Trout");
            box = new StringBox("Lobster");
            box = new StringBox("Bear");
            System.gc();
            Thread.sleep(2000);
            System.out.println("The box now contains: " +box);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private class StringBox {
        private final String value;

        public StringBox(String s) {
            this.value = s;
        }

        public String getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if(!(o instanceof StringBox)) return false;
            return value.equals(((StringBox) o).value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return "[" + value + "]";
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("Cleaning up box[" + value + "]");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        new FinalizeTest().boxTest();
    }
}
