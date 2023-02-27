package com.github.fadeciness.lesson2.homework.model;

import com.github.fadeciness.lesson2.homework.ability.Movement;

public class Human implements Movement {

    private final int jumpHeight;
    private final int runLength;
    private final int swimLength;

    public Human(int jumpHeight, int runLength, int swimLength) {
        this.jumpHeight = jumpHeight;
        this.runLength = runLength;
        this.swimLength = swimLength;
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
        return "Human{" +
                "jumpHeight=" + jumpHeight +
                ", runLength=" + runLength +
                ", swimLength=" + swimLength +
                '}';
    }

    @Override
    public int swim() {
        System.out.println(this + " swam through");
        return swimLength;
    }
}
