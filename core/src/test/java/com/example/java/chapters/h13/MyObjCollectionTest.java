package com.example.java.chapters.h13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyObjCollectionTest {
    @Test
    void testMyCollInts() {
        MyObjCollection<String> stringMyObjCollection = new MyObjCollection<>();
        assertTrue(stringMyObjCollection.isEmpty());

        for(int i = 0; i < 12; i++) {
            stringMyObjCollection.add(Integer.toString(i));
        }

        assertEquals(12, stringMyObjCollection.size());
        System.out.println(stringMyObjCollection.toString());
    }

}