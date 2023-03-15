package com.github.fadeciness.lesson7.homework;

public class Road extends Stage {

    private Object object;
    private boolean finalist;

    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
        this.isLast = false;
        this.object = new Object();
        this.finalist = false;
    }

    public Road(int length, boolean isLast) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
        this.isLast = isLast;
        this.object = new Object();
        this.finalist = false;
    }
    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            if (isLast) {
                synchronized (object) {
                    if (!this.finalist) {
                        this.finalist = true;
                        System.out.println(c.getName() + " === WIN!!!");
                    } else {
                        System.out.println(c.getName() + " закончил этап: " + description);
                    }
                }
            } else {
                System.out.println(c.getName() + " закончил этап: " + description);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
