package com.github.fadeciness.lesson7.classwork.p5_executor_service;

import java.util.concurrent.*;

public class ResponseFromThreadTask {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        Future<String> stringFuture = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "Java";
            }
        }); // future = результат выполнения задачи
        try {
            String result = stringFuture.get(); // аналог join - ожидаем выполнения
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }

}
