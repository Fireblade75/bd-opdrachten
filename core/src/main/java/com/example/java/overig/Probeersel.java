package com.example.java.overig;

import java.util.HashMap;
import java.util.Objects;

public class Probeersel {
    void run() {
        var map = new HashMap<>();
        map.put("hoi", 7);
        map.put("nee", 8);

        map.forEach((key, value) -> {
            System.out.printf("%s:%s%n", key, value);
        });
    }

    public static void main(String[] args) {
        new Probeersel().run();
    }

    final class Point {
        public final int x;
        public final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
