package com.github.fadeciness.lesson5.homework.utils;

import java.util.*;

public class ArrayUtils {

    public static <T> Set<T> uniqueElements(T[] arr) {
        return new HashSet<>(Arrays.asList(arr));
    }

    public static <T> Map<T, Integer> countEntries(T[] arr) {
        HashMap<T, Integer> result = new HashMap<>();
        for (T element : arr) {
            Integer count = result.getOrDefault(element, 0);
            result.put(element, ++count);
        }
        return result;
    }

}
