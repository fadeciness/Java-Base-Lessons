package com.github.fadeciness.lesson4.homework.service;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayCollectionUtils {

    public static <T> ArrayList<T> convert(T[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Массив указывает на null");
        }
        ArrayList<T> result = new ArrayList<>(array.length);
        result.addAll(Arrays.asList(array));
        return result;
    }

}
