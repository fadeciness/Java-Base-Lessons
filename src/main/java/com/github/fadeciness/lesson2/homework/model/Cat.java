package com.github.fadeciness.lesson2.homework.model;

import com.github.fadeciness.lesson2.homework.ability.Movement;

public class Cat implements Movement {

    private final int jumpHeight;
    private final int runLength;

    public Cat(int jumpHeight, int runLength) {
        this.jumpHeight = jumpHeight;
        this.runLength = runLength;
    }

    @Override
    public int jump() {
        System.out.println(this + " jumped");
        return jumpHeight;
    }

    @Override
    public int run() {
        System.out.println(this + " ran");
        return runLength;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "jumpHeight=" + jumpHeight +
                ", runLength=" + runLength +
                '}';
    }

    @Override
    public int swim() {
        return 0;
    }
}
