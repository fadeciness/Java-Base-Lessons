package com.github.fadeciness.lesson2.homework.model;

import com.github.fadeciness.lesson2.homework.ability.Movement;

public class Fish implements Movement {

    private final int swimLength;

    public Fish(int swimLength) {
        this.swimLength = swimLength;
    }

    @Override
    public int jump() {
        return 0;
    }

    @Override
    public int run() {
        return 0;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "swimLength=" + swimLength +
                '}';
    }

    @Override
    public int swim() {
        System.out.println(this + " swam through");
        return swimLength;
    }
}
