package com.example.h11;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class AnimalService {
    public List<Animal> sortAnimalList(List<Animal> animals) {
        animals.sort((a1, a2) -> a1.getName().compareToIgnoreCase(a2.getName()));
        return animals;
    }

    private class Animal {
        public String getName() {
            return null;
        }
    }
}
