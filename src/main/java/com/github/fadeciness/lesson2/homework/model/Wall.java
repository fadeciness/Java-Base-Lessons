package com.github.fadeciness.lesson2.homework.model;

import com.github.fadeciness.lesson2.homework.ability.Barrier;
import com.github.fadeciness.lesson2.homework.ability.Movement;

public class Wall implements Barrier {

    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean isOverpassed(Movement movement) {
        int dimension = movement.jump();
        return dimension >= this.height;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "height=" + height +
                '}';
    }
}
