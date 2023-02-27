package com.github.fadeciness.lesson4.homework.model;

public class Apple extends Fruit {
    private static final float WEIGHT = 1.0F;

    @Override
    public float getWeight() {
        return WEIGHT;
    }

    @Override
    public String toString() {
        return "Apple{}";
    }
}
