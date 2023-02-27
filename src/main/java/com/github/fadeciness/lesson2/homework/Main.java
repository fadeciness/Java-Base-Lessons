package com.github.fadeciness.lesson2.homework;

import com.github.fadeciness.lesson2.homework.ability.Barrier;
import com.github.fadeciness.lesson2.homework.ability.Movement;
import com.github.fadeciness.lesson2.homework.model.*;

public class Main {
    public static void main(String[] args) {
        Barrier[] barriers = {
                new Pool(100 * 100),
                new Pool(100 * 750),
                new Wall(100),
                new Treadmill(100 * 1000),
                new MegaWall(),
                new Wall(120),
                new Wall(140),
                new Wall(160),
                new Treadmill(100 * 2000),
                new Treadmill(100 * 500)
        };

        Movement[] participants = {
                new Cat(120, 100 * 500),
                new Cat(120, 100 * 1000),
                new Human(200, 100 * 1000, 100*100),
                new Human(280, 100 * 5000, 100*25),
                new Fish(100*10_000),
                new Human(140, 100 * 2000, 100*1000),
                new Human(170, 100 * 1800, 100*500),
                new Robot(300, 100 * 10000),
                new Robot(300, 100 * 10000),
                new Robot(300, 100 * 10000)
        };

        for (Movement participant : participants) {
            boolean hasOneFail = false;
            for (Barrier barrier : barriers) {
                boolean isOverpassed = barrier.isOverpassed(participant);
                if (!isOverpassed) {
                    System.out.println("I: " + participant + " can't overcome an obstacle: " + barrier);
                    hasOneFail = true;

                    break;
                } else {
                    System.out.println("I: " + participant + " successfully overcome an obstacle: " + barrier);
                }
            }
            if (!hasOneFail) {
                System.out.println("I: " + participant + " overcame all obstacles");
            }
        }
    }

}
