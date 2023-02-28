package com.github.fadeciness.lesson4.homework;

import com.github.fadeciness.lesson4.homework.model.Apple;
import com.github.fadeciness.lesson4.homework.model.Box;
import com.github.fadeciness.lesson4.homework.model.Fruit;
import com.github.fadeciness.lesson4.homework.model.Orange;
import com.github.fadeciness.lesson4.homework.service.ArrayCollectionUtils;
import com.github.fadeciness.lesson4.homework.service.ArrayElementReplacer;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1: поменять местами 2 элемента массива");
        Integer[] arr1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] arr2 = {"a", "b", "c", "d", "e"};
        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));
        ArrayElementReplacer.swap(arr1, 0, 9);
        ArrayElementReplacer.swap(arr2, 0, 4);
        System.out.println("Processed array 1: " + Arrays.toString(arr1));
        System.out.println("Processed array 2: " + Arrays.toString(arr2));
        System.out.println("Задание 1 завершено\n\n\n\n");

        System.out.println("Задание 2: преобразовать массив в ArrayList");
        Integer[] arr3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Array: " + Arrays.toString(arr3));
        ArrayList<Integer> arr3AsArrayList = ArrayCollectionUtils.convert(arr3);
        System.out.println("ArrayList: " + arr3AsArrayList);
        System.out.println("Задание 2 завершено\n\n\n\n");

        System.out.println("Задание 3: фрукты и коробки");
        Box<Fruit> fruitBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        fruitBox.addFruits(
                new Apple(),
                new Orange(),
                new Apple(),
                new Orange(),
                new Apple()
        );
        appleBox.addFruits(
                new Apple(),
                new Apple(),
                new Apple(),
                new Apple(),
                new Apple()
        );
        orangeBox.addFruits(
                new Orange(),
                new Orange(),
                new Orange(),
                new Orange(),
                new Orange()
        );

        System.out.println("Вес коробки с яблоками: " + appleBox.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());
        System.out.println("Вес смешанной коробки: " + fruitBox.getWeight());

        boolean compareOA = orangeBox.compareToWrapper(appleBox);
        System.out.println("Сравнение коробки с апельсинами и коробки с яблоками: " + compareOA);
        boolean compareOF = orangeBox.compareToWrapper(fruitBox);
        System.out.println("Сравнение коробки с апельсинами и смешанной коробки: " + compareOF);
        boolean compareAF = appleBox.compareToWrapper(fruitBox);
        System.out.println("Сравнение коробки с яблоками и смешанной коробки: " + compareAF);

        Box<Orange> newOrangeBox = new Box<>();
        Box<Apple> newAppleBox = new Box<>();
        Box<Fruit> newFruitBox = new Box<>();
        System.out.println("Новая коробка с апельсинами: " + newOrangeBox);
        System.out.println("Новая коробка с яблоками: " + newAppleBox);
        System.out.println("Новая смешанная коробка: " + newFruitBox);

        orangeBox.sprinkle(newOrangeBox);
        System.out.println("Старая коробка с апельсинами: " + orangeBox);
        System.out.println("Новая коробка с апельсинами: " + newOrangeBox);

        appleBox.sprinkle(newAppleBox);
        System.out.println("Старая коробка с яблоками: " + appleBox);
        System.out.println("Новая коробка с яблоками: " + newAppleBox);

        fruitBox.sprinkle(newFruitBox);
        System.out.println("Старая смешанная коробка: " + fruitBox);
        System.out.println("Новая смешанная коробка: " + newFruitBox);


        System.out.println("Задание 3 завершено\n\n\n\n");
    }
}
