package com.example.java.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalListTest {

    List<ItemDescriptor> itemDescriptors = new ArrayList<>();

    public void addItem(ItemDescriptor newItem) {
        boolean noMatch = itemDescriptors.stream().noneMatch(item -> item.itemName.equals(newItem.itemName()));
        if(noMatch) {
            itemDescriptors.add(newItem);
        } else {
            throw new ItemException("Item is already present");
        }
    }

    public Integer getWeight1(String name) {
        return itemDescriptors.stream().filter(item -> item.itemName().equals(name))
                .map(item -> item.weight).findFirst().orElseThrow(ItemException::new);
    }

    public Integer getWeight2(String name) {
        // met Optional.of wordt er een nullpointer gegeven
        return Optional.ofNullable(getItem(name)).map(ItemDescriptor::weight)
                .stream().findFirst().orElseThrow(ItemException::new);
    }

    public ItemDescriptor getItem(String name) {
        for(ItemDescriptor item : itemDescriptors) {
            if(item.itemName().equals(name)) {
                return item;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        OptionalListTest listTest = new OptionalListTest();
        listTest.addItem(new ItemDescriptor("apple", 2));
        System.out.println(listTest.getWeight1("apple").toString());
        System.out.println(listTest.getWeight2("apple").toString());

        try {
            System.out.println(listTest.getWeight1("pear").toString());
        } catch (ItemException e) {
            System.out.println(e.getClass().getSimpleName());
        }
        try {
            System.out.println(listTest.getWeight2("pear").toString());
        } catch (ItemException e) {
            System.out.println(e.getClass().getSimpleName());
        }
    }

    public static class ItemDescriptor {
        private final String itemName;
        private final int weight;

        private ItemDescriptor(String itemName, int weight) {
            this.itemName = itemName;
            this.weight = weight;
        }

        public String itemName() {
            return itemName;
        }

        public int weight() {
            return weight;
        }

        @Override
        public String toString() {
            return itemName + ": " + weight + " kg";
        }
    }

    public static class ItemException extends RuntimeException {
        public ItemException() {

        }

        public ItemException(String s) {
            super(s);
        }
    }
}
