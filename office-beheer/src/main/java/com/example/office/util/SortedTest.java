package com.example.office.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortedTest {
    public static void main(String[] args) {
        var test = new SortedTest();
        test.intSort();
        System.out.println("---");
        test.labeledIntSort();
    }

    public void intSort() {
        Set<Integer> sortedSet = new TreeSet<>(List.of(
                4, 41, 2, 88, 41, 9
        ));

        sortedSet.forEach(System.out::println);
        System.out.println("---");

        List<Integer> list = new ArrayList<>(sortedSet);
        list.forEach(System.out::println);
    }

    public void labeledIntSort() {
        Set<LabeledIntBox> sortedSet = new TreeSet<>(List.of(
                new LabeledIntBox("D", 4),
                new LabeledIntBox("F", 41),
                new LabeledIntBox("C", 4),
                new LabeledIntBox("E", 888),
                new LabeledIntBox("A", 41),
                new LabeledIntBox("C", 4)
        ));

        sortedSet.forEach(System.out::println);
        System.out.println("---");

        List<LabeledIntBox> list = new ArrayList<>(sortedSet);
        list.forEach(System.out::println);
    }

    private static class LabeledIntBox implements Comparable<LabeledIntBox> {
        private String label;
        private int value;

        private LabeledIntBox(String label, int value) {
            this.label = label;
            this.value = value;
        }

        @Override
        public int compareTo(LabeledIntBox o) {
            int compareVal = Integer.compare(value, o.value);
            if (compareVal == 0 && label != null && o.label != null) {
                return label.compareTo(o.label);
            }
            return compareVal;
        }

        @Override
        public String toString() {
            return "LabeledIntBox{" +
                    "label='" + label + '\'' +
                    ", value=" + value +
                    '}';
        }
    }
}
