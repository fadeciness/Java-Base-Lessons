package com.github.fadeciness.lesson4.homework.service;

public class ArrayElementReplacer {

    // По большому счету здесь не требуется обобщеный тип, достаточно Object
    public static <T> void swap(T[] arr, int index1, int index2) {
        if (index1 < 0 || index2 < 0) {
            throw new IllegalArgumentException("Значение индекса не может быть отрицательным числом");
        }
        if (index1 > arr.length - 1 || index2 > arr.length - 1) {
            throw new IllegalArgumentException("Значение индекса(-ов) лежит вне границ массива (максимальный индекс: " + (arr.length-1) + ")");
        }
        T element1 = arr[index1];
        T element2 = arr[index2];
        arr[index1] = element2;
        arr[index2] = element1;
    }

}
