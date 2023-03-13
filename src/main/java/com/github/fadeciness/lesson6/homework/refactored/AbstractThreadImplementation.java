package com.github.fadeciness.lesson6.homework.refactored;

import java.util.Arrays;

public abstract class AbstractThreadImplementation {

    protected static final int SIZE = 10_000_000;
    protected static final int HALF = SIZE / 2;
    protected final float[] arr = new float[SIZE];

    public AbstractThreadImplementation() {
        Arrays.fill(arr, 1.0f);
    }

    public abstract void execute();

    public float[] getArr() {
        return arr;
    }

}
