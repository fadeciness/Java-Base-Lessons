package com.github.fadeciness.lesson2.homework.model;

import com.github.fadeciness.lesson2.homework.ability.Barrier;
import com.github.fadeciness.lesson2.homework.ability.Movement;

public class Treadmill implements Barrier {

    private final int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public boolean isOverpassed(Movement movement) {
        int dimension = movement.run();
        return dimension >= length;
    }

    @Override
    public String toString() {
        return "Treadmill{" +
                "length=" + length +
                '}';
    }
}
