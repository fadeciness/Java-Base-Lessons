package com.github.fadeciness.lesson1.homework.animal;

public class HomeCat extends Cat {
    private static final int RUN_LIMIT = 200;
    private static final int SWIM_LIMIT = 0;

    public HomeCat(String name, int age) {
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

    @Override
    public void swim(int meter) {
        System.out.println(name + ": I can't swim");
    }

}
