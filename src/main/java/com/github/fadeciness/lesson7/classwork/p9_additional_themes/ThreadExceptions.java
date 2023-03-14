package com.github.fadeciness.lesson7.classwork.p9_additional_themes;

public class ThreadExceptions {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            int x = 10;
            System.out.println(1);
            x = x / 0;
            System.out.println(2);
        });
//        Thread.setDefaultUncaughtExceptionHandler(...);
        t.setUncaughtExceptionHandler(
                new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        e.printStackTrace();
                        System.out.println("Caught");
                    }
                }
        );
        t.start();
    }
}
