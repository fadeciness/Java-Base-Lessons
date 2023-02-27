package com.github.fadeciness.lesson1.homework.service.counter;

import com.github.fadeciness.lesson1.homework.animal.Animal;

import java.util.HashMap;
import java.util.Map;

public class AnimalCounterService {

    public static Map<Class<? extends Animal>, Integer> calculate(Animal[] animals) {
        HashMap<Class<? extends Animal>, Integer> count = new HashMap<>();
        for (Animal a : animals) {
            Integer prevValue = count.getOrDefault(a.getClass(), 0);
            count.put(a.getClass(), prevValue + 1);
        }
        count.put(Animal.class, animals.length);
        return count;
    }

}
