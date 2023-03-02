package com.github.fadeciness.lesson6.classwork.p1_thread_creation_and_base;

public class ThreadExampleClass extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("thread-"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadExampleClass t = new ThreadExampleClass();
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main-"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
