package com.github.fadeciness.lesson1.homework.animal;

public class Tiger extends Cat {

    private static final int RUN_LIMIT = 400;
    private static final int SWIM_LIMIT = 25;

    public Tiger(String name, int age) {
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
