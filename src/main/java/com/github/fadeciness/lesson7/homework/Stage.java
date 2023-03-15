package com.github.fadeciness.lesson7.homework;

public abstract class Stage {
    protected int length;
    protected String description;
    protected boolean isLast;
    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);

    public boolean getIsLast() {
        return isLast;
    }

}
