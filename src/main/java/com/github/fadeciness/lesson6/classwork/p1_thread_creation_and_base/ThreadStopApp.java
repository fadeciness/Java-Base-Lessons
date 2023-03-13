package com.github.fadeciness.lesson6.classwork.p1_thread_creation_and_base;

public class ThreadStopApp {
    public static void main(String[] args) {
        correct();
//        badIdea();
    }

    public static void correct() {
        Thread t = new Thread(() -> {
            boolean inter = false;
            while (true) {
                if (Thread.currentThread().isInterrupted() || inter) {
                    break;
                }
                System.out.println("tick");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    inter = true;
                }
            }
        });
        t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }

    public static void badIdea() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("tick");
            }
        });
        t.start();

        try {
            Thread.sleep(1000);
            t.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
