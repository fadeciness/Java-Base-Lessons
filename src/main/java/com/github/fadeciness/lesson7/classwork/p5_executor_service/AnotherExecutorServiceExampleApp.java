package com.github.fadeciness.lesson7.classwork.p5_executor_service;

import java.util.concurrent.*;

/*
Это перехват исключений из потоков внутри executor
Перехват исключений из обычного потока (без executor) см. SimpleThreadExceptions
 */
public class AnotherExecutorServiceExampleApp {
    public static void main(String[] args) throws Exception {
        // Потоки в пуле последовательно создаются, пока не заполнится пул
        // затем происходит переиспользование
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<String> future = service.submit(() -> {
            Thread.sleep(3000);
            return "Java";
        });

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("END");
        service.shutdown();

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(4, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("My custom name");
                System.out.println("Created");
                return thread;
            }
        }); // позволяет запускать задачи по таймеру
        // таймер по моменту запуска: запускать каждые N сек
        // таймер между окончанием и началом следующей задачи
        scheduledThreadPool.schedule(() -> System.out.println("Hello 1"), 3, TimeUnit.SECONDS);
        Thread.sleep(5000);
        scheduledThreadPool.schedule(() -> System.out.println("Hello 2"), 3, TimeUnit.SECONDS);
        Thread.sleep(5000);
        scheduledThreadPool.schedule(() -> System.out.println("Hello 3"), 3, TimeUnit.SECONDS);
        Thread.sleep(5000);
        scheduledThreadPool.schedule(() -> System.out.println("Hello 4"), 3, TimeUnit.SECONDS);
        Thread.sleep(5000);
        scheduledThreadPool.schedule(() -> System.out.println("Hello 5"), 3, TimeUnit.SECONDS);
        Thread.sleep(5000);
        scheduledThreadPool.schedule(() -> System.out.println("Hello 6"), 3, TimeUnit.SECONDS);
        Thread.sleep(5000);
        scheduledThreadPool.schedule(() -> System.out.println("Hello 7"), 3, TimeUnit.SECONDS);
        scheduledThreadPool.shutdown();
    }
}
