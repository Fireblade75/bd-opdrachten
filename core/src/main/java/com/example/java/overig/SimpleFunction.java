package com.example.java.overig;

import java.util.HashMap;
import java.util.List;

public class SimpleFunction {

    static void giveMeAni(HashMap<Integer, Integer> map) {
        map.put(4, 8);
    }

    static void giveMeAn(HashMap<String, Integer> map) {
        map.put("a", 5);
    }

    static void transfer(List<? extends Number> from, List<? super Number> to) {
        for(var value : from) {
            to.add(value);
        }
    }

    public static void main(String[] args) {
        giveMeAn(new HashMap<>());
    }

    public <T> T doeIets(T t) {
        return t;
    }

}
