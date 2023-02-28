package com.github.fadeciness.lesson4.homework.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> implements Comparable<Box<? extends Fruit>> {

    private final static float COMPARE_THRESHOLD = 0.001F;

    private final List<T> container;

    public Box() {
        this.container = new ArrayList<>();
    }

    @SafeVarargs
    public Box(T... fruits) {
        this.container = new ArrayList<>(Arrays.asList(fruits));
    }

    public List<T> getContainer() {
        return container;
    }

    public void add(T fruit) {
        container.add(fruit);
    }

    @SafeVarargs
    public final void addFruits(T... fruits) {
        container.addAll(Arrays.asList(fruits));
    }

    public void sprinkle(Box<T> newBox) {
        if (this != newBox) {
            newBox.container.addAll(this.container);
            this.container.clear();
        }
    }

    public float getWeight() {
        float result = 0.0F;
        for (T fruit : container) {
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
                "fruits=" + container +
                '}';
    }
}
