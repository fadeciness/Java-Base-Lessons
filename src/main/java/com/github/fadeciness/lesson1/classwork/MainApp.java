package com.github.fadeciness.lesson1.classwork;

import com.github.fadeciness.lesson1.classwork.animal.Cat;
import com.github.fadeciness.lesson1.classwork.animal.Dog;

public class MainApp {

    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", "White", 2);
        Cat cat2 = new Cat("Murzik", "Black", 4);
        Dog dog = new Dog("Bobik", "Orange", 3);

        cat.info();
        cat2.info();
        dog.info();

        cat.voice();
        cat2.voice();
        dog.voice();

    }

}
