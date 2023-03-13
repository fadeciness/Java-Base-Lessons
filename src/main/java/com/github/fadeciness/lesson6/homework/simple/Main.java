package com.github.fadeciness.lesson6.homework.simple;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        SingleThreadImplementation.execute();
        long end = System.currentTimeMillis();
        System.out.println("Общее время выполнения без распараллеливания: " + (end - start) + " ms");

        long start2 = System.currentTimeMillis();
        ParallelThreadImplementation.execute();
        long end2 = System.currentTimeMillis();
        System.out.println("Общее время выполнения с распараллеливанием: " + (end2 - start2) + " ms");

        float[] singleArr = SingleThreadImplementation.getArr();
        float[] parallelArr = ParallelThreadImplementation.getArr();
        int compareRes = Arrays.compare(singleArr, parallelArr);
        System.out.println("Идентичные ли массивы: " + compareRes);
    }



}
