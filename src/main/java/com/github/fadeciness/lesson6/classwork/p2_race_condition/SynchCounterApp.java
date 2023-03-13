package com.github.fadeciness.lesson6.classwork.p2_race_condition;

public class SynchCounterApp {
    public static void main(String[] args) {
        SynchCounter counter = new SynchCounter();

        Thread incThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.inc();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread decThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.dec();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            incThread.start();
            decThread.start();
            incThread.join();
            decThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Значение синхр. счетчика: "+counter.value());
    }
}
