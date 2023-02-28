package com.github.fadeciness.lesson4.homework.model;

public class Orange extends Fruit {

    private static final float WEIGHT = 1.5F;

    public Orange() {
        super(WEIGHT);
    }

    @Override
    public String toString() {
        return "Orange{}";
    }
}
