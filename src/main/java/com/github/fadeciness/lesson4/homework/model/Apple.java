package com.github.fadeciness.lesson4.homework.model;

public class Apple extends Fruit {
    private static final float WEIGHT = 1.0F;

    public Apple() {
        super(WEIGHT);
    }

    @Override
    public String toString() {
        return "Apple{}";
    }
}
