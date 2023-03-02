package com.github.fadeciness.lesson6.classwork.p1_thread_creation_and_base;

public class AnonymousExampleClass {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        t.start();
        // Заставляем main поток ждать выполнения потока t (END напечатается после цифр 1...9)
        try {
            t.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("END");
    }
}
