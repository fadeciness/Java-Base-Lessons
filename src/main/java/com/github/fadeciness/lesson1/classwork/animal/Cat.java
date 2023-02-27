package com.github.fadeciness.lesson1.classwork.animal;

public class Cat extends Animal {

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @Override
    public void voice() {
        System.out.println(name + ": meow-meow");
    }
}
