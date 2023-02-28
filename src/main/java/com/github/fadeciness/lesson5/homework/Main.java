package com.github.fadeciness.lesson5.homework;

import com.github.fadeciness.lesson5.homework.dictionary.PhoneDictionary;
import com.github.fadeciness.lesson5.homework.utils.ArrayUtils;

import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1: уникальные элементы массива и их количество");
        Integer[] arr1 = null;
        String[] arr2 = {
                "A",
                "AA",
                "AAA",
                "B",
                "AA",
                "AAA",
                "AAA"
        };
        Set<String> result = ArrayUtils.uniqueElements(arr2);
        System.out.println(result);
        Map<String, Integer> countRes = ArrayUtils.countEntries(arr2);
        System.out.println(countRes);
        System.out.println("Задание 1 выполнено");

        System.out.println("Задание 2: телефонный справочник");
        PhoneDictionary myDictionary = new PhoneDictionary();
        myDictionary.add("ivanov", "1", "2", "3");
        myDictionary.add("petrov", "1", "1", "1");
        myDictionary.add("sergeev", "2", "1");

        System.out.println("ivanov: " + myDictionary.get("ivanov"));
        System.out.println("petrov: " + myDictionary.get("petrov"));
        System.out.println("sergeev: " + myDictionary.get("sergeev"));
        System.out.println("Задание 2 выполнено");
    }
}
