package com.github.fadeciness.lesson2.homework.model;

import com.github.fadeciness.lesson2.homework.ability.Barrier;
import com.github.fadeciness.lesson2.homework.ability.Movement;

public class MegaWall implements Barrier {
    @Override
    public boolean isOverpassed(Movement movement) {
        return movement.jump() + movement.run() > 500_000 + 100_000;
    }

    @Override
    public String toString() {
        return "MegaWall{}";
    }
}
