package com.github.fadeciness.lesson6.homework.simple;

import java.util.Arrays;

public class SingleThreadImplementation {

    private static final int SIZE = 10_000_000;
    private static final int HALF = SIZE / 2;
    private static final float[] arr = new float[SIZE];

    static {
        Arrays.fill(arr, 1.0f);
    }

    public static void execute() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5.0f) * Math.cos(0.2f + i / 5.0f) *
                    Math.cos(0.4f + i / 2.0f));
        }
        long end = System.currentTimeMillis();
        System.out.println("Время выполнения простой реализации: " + (end - start) + " ms");
    }

    public static float[] getArr() {
        return arr;
    }

}
