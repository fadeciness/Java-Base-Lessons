package com.github.fadeciness.lesson1.classwork.animal;

public abstract class Animal {
    protected String name;
    protected String color;
    protected int age;

    public void info() {
        System.out.println(name + " " + color + " " + age);
    }

//    public void voice() {
//        System.out.println(name + " voice");
//    }

    public abstract void voice();

}
