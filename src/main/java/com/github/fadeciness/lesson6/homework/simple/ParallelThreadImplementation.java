package com.github.fadeciness.lesson6.homework.simple;

import java.util.Arrays;

public class ParallelThreadImplementation {

    private static final int SIZE = 10_000_000;
    private static final int HALF = SIZE / 2;
    private static final float[] arr = new float[SIZE];

    static {
        Arrays.fill(arr, 1.0f);
    }

    public static void execute() throws InterruptedException {
        long start = System.currentTimeMillis();
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);
        long end = System.currentTimeMillis();
        System.out.println("Время разбивки массива arr: " + (end - start) + " ms");

//        start = System.currentTimeMillis();
        Thread th1 = new Thread(() -> {
            long startTh1 = System.currentTimeMillis();
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5.0f) * Math.cos(0.2f + i / 5.0f) *
                        Math.cos(0.4f + i / 2.0f));
            }
            long endTh1 = System.currentTimeMillis();
            System.out.println("Время выполнения первого потока: " + (endTh1 - startTh1) + " ms");
        });
        Thread th2 = new Thread(() -> {
            long startTh2 = System.currentTimeMillis();
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float) (a2[i] * Math.sin(0.2f + (i + HALF) / 5.0f) * Math.cos(0.2f + (i + HALF) / 5.0f) *
                        Math.cos(0.4f + (i + HALF) / 2.0f));
            }
            long endTh2 = System.currentTimeMillis();
            System.out.println("Время выполнения первого потока: " + (endTh2 - startTh2) + " ms");
        });
        th1.start();
        th2.start();
        th1.join();
        th2.join();
//        end = System.currentTimeMillis();
//        System.out.println("Время разбивки массива arr: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);
        end = System.currentTimeMillis();
        System.out.println("Время обратной склейки массивов: " + (end - start) + " ms");
    }

    public static float[] getArr() {
        return arr;
    }

}
