package com.github.fadeciness.lesson1.homework;

import com.github.fadeciness.lesson1.homework.animal.Animal;
import com.github.fadeciness.lesson1.homework.animal.Dog;
import com.github.fadeciness.lesson1.homework.animal.HomeCat;
import com.github.fadeciness.lesson1.homework.animal.Tiger;
import com.github.fadeciness.lesson1.homework.service.counter.AnimalCounterService;

import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("The application has started");
        int toRun = new Random().nextInt(500);
        int toSwim = new Random().nextInt(30);

        Animal[] animals = {
                new HomeCat("Tomcat", 1),
                new HomeCat("Bobcat", 2),
                new Dog("Hotdog", 3),
                new Dog("Barkdog", 4),
                new Tiger("Sabercat", 5),
                new Tiger("Stripedcat", 6),
        };
        System.out.println("Initialization is finished");

        System.out.println("The animal race has begun");
        for (Animal animal : animals) {
            animal.run(toRun);
            animal.swim(toSwim);
        }
        System.out.println("The animal race is over");

        System.out.println("The counting of the animals participating in the race has begun");
        Map<Class<? extends Animal>, Integer> count = AnimalCounterService.calculate(animals);
        System.out.println("The counting of the animals participating in the race ended with the results: " + count);


        System.out.println("The application has finished");
    }

}
