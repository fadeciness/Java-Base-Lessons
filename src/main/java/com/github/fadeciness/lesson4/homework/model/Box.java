package com.github.fadeciness.lesson4.homework.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Box<T extends Fruit> implements Comparable<Box<? extends Fruit>> {

    private final static float COMPARE_THRESHOLD = 0.001F;

    private final List<T> fruits = new ArrayList<>();

    public List<T> getFruits() {
        return fruits;
    }

    public boolean addFruit(T fruit) {
        return fruits.add(fruit);
    }

    public boolean addFruits(List<T> fruit) {
        return fruits.addAll(fruit);
    }

    public void sprinkle(Box<T> newBox) {
        newBox.addFruits(this.fruits);
        this.fruits.clear();
    }

    public float getWeight() {
        float result = 0;
        for (T fruit : fruits) {
            result += fruit.getWeight();
        }
        return result;
    }

    @Override
    public int compareTo(Box<? extends Fruit> o) {
        float difference = this.getWeight() - o.getWeight();
        if (Math.abs(difference) <= COMPARE_THRESHOLD) {
            return 0;
        }
        if (difference < 0.0F) {
            return -1;
        }
        return 1;
    }

    public boolean compareToWrapper(Box<? extends Fruit> o) {
        return compareTo(o) == 0;
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruits=" + fruits +
                '}';
    }
}
