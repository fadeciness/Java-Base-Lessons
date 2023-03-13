package com.github.fadeciness.lesson6.homework.refactored;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        SingleThreadImplementation singleThreadImplementation = new SingleThreadImplementation();
        singleThreadImplementation.execute();
        long end = System.currentTimeMillis();
        System.out.println("Общее время выполнения без распараллеливания: " + (end - start) + " ms");

        long start2 = System.currentTimeMillis();
        ParallelThreadImplementation parallelThreadImplementation = new ParallelThreadImplementation();
        parallelThreadImplementation.execute();
        long end2 = System.currentTimeMillis();
        System.out.println("Общее время выполнения с распараллеливанием: " + (end2 - start2) + " ms");

        float[] singleArr = singleThreadImplementation.getArr();
        float[] parallelArr = parallelThreadImplementation.getArr();
        int compareRes = Arrays.compare(singleArr, parallelArr);
        System.out.println("Идентичные ли массивы: " + compareRes);
    }



}
