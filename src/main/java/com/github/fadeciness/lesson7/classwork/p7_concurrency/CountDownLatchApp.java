package com.github.fadeciness.lesson7.classwork.p7_concurrency;

import java.util.concurrent.CountDownLatch;

// Продвинутый вариант join
// нам не нужны ссылки на потоки для этого
public class CountDownLatchApp {
    public static void main(String[] args) {
        final int THREADS_COUNT = 6;
        final CountDownLatch countDownLatch = new CountDownLatch(THREADS_COUNT);
//        final CountDownLatch countDownLatch = new CountDownLatch(THREADS_COUNT+1);

        System.out.println("Начинаем");
        for (int i = 0; i < THREADS_COUNT; i++) {
            final int w = i;
            new Thread(() -> {
                try {
                    Thread.sleep(200 * w + (int) (500 * Math.random()));
                    System.out.println("Поток #" + w + " - готов");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        try {
            countDownLatch.await();
            // ожидание пока защёлка не прощёлкает THREADS_COUNT раз
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Работа завершена");
    }

}
