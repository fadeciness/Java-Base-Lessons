package com.github.fadeciness.lesson2.homework.model;

import com.github.fadeciness.lesson2.homework.ability.Barrier;
import com.github.fadeciness.lesson2.homework.ability.Movement;

public class Pool implements Barrier {

    private final int poolLength;

    public Pool(int poolLength) {
        this.poolLength = poolLength;
    }

    @Override
    public boolean isOverpassed(Movement movement) {
        int dimension = movement.swim();
        return dimension >= poolLength;
    }

    @Override
    public String toString() {
        return "Pool{" +
                "poolLength=" + poolLength +
                '}';
    }
}
