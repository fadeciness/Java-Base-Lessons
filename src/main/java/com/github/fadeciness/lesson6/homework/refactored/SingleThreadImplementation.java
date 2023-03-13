package com.github.fadeciness.lesson6.homework.refactored;

public class SingleThreadImplementation extends AbstractThreadImplementation {

    @Override
    public void execute() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5.0f) * Math.cos(0.2f + i / 5.0f) *
                    Math.cos(0.4f + i / 2.0f));
        }
    }

}
