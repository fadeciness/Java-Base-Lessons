package com.github.fadeciness.lesson1.homework.animal;

public abstract class Animal {

    protected String name;

    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract int getRunLimit();
    public abstract int getSwimLimit();

    public void run(int meter) {
        if (meter < 0) {
            throw new IllegalArgumentException("Negative distance is set");
        } else if (meter > getRunLimit()) {
                System.out.println(name + ": I can't run a lot");
        } else {
            System.out.println(name + ": I ran: " + meter + " meters");
        }
    }
    public void swim(int meter) {
        if (meter < 0) {
            throw new IllegalArgumentException("Negative distance is set");
        } else if (meter > getSwimLimit()) {
            System.out.println(name + ": I can't swim very much");
        } else {
            System.out.println(name + ": I swam: " + meter + " meters");
        }
    }

}
