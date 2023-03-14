package com.github.fadeciness.lesson7.classwork.p7_concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

// Синхронизация между собой этапа некоторого количества потоков
public class CyclicBarrierApp {
    public static void main(String[] args) {
        final int THREADS_COUNT = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREADS_COUNT);

        for (int i = 0; i < THREADS_COUNT; i++) {
            int w = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Подготавливается " + w);
                    try {
                        Thread.sleep(2000 + 500 * (int) (Math.random() *  10));
                        System.out.println("Готов " + w);
                        cyclicBarrier.await();
                        System.out.println("Поехал " + w);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    } finally {

                    }
                }
            }).start();


        }
    }
}
