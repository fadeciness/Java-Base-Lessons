package com.github.fadeciness.lesson4.homework.model;

public class Orange extends Fruit {

    private static final float WEIGHT = 1.5F;

    @Override
    public float getWeight() {
        return WEIGHT;
    }

    @Override
    public String toString() {
        return "Orange{}";
    }
}
