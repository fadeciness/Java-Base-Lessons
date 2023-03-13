package com.github.fadeciness.lesson6.classwork.p1_thread_creation_and_base;

public class DaemonExample {
    public static void main(String[] args) {
        Thread tTimer = new Thread(() -> {
            int time = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                    time++;
                    System.out.println("Time: " + time);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        tTimer.setDaemon(true); // можно закомментировать: тогда main не остановится никогда
//        tTimer.getState(); - бессмысленная операция - вернёт состояние потока в момент когда мы спросили, однако через 1 такт поток уже может сменить состояние
//        tTimer.stop(); // не использовать, т.к. могут повредиться данные / "не отпуститься" ресурсы см. ThreadStopApp
        tTimer.start();
        System.out.println("main -> sleep");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("main -> end");
    }
}
