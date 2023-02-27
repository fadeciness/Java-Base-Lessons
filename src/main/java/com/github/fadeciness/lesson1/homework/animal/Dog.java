package com.github.fadeciness.lesson1.homework.animal;

public class Dog extends Animal {

    private static final int RUN_LIMIT = 500;
    private static final int SWIM_LIMIT = 10;

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public int getRunLimit() {
        return RUN_LIMIT;
    }

    @Override
    public int getSwimLimit() {
        return SWIM_LIMIT;
    }

}
