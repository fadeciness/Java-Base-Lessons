package com.github.fadeciness.lesson7.classwork.p6_locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleLockApp {

    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        /*
            по сути позволяют построить блок команд по типу synchronized
            отличия:
            1) lock можно вызывать в разных блоках видимости
            2) у lock есть tryLock метод
            3) lockInterruptibly - позволяет среагировать на InterruptedException

            После lock КРАЙНЕ ЖЕЛАТЕЛЬНО использовать try-finally
         */

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println("T-BEFORE-LOCK-1");
                lock.lock();
                System.err.println("T-GET-LOCK-1");
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.err.println("T-END-1");
                    lock.unlock();
                }
            }
        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.err.println("T-BEFORE-LOCK-2");
//                lock.lock();
//                System.err.println("T-GET-LOCK-2");
//                try {
//                    Thread.sleep(8000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    System.err.println("T-END-2");
//                    lock.unlock();
//                }
//            }
//        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println("T-BEGIN-3");
                try {
                    if (lock.tryLock(5, TimeUnit.SECONDS)) { // пробуем захватить в течение 5 секунд, иначе не выполняем задачу
                        try {
                            System.err.println("T-LOCK-SECTION-3");
                            try {
                                Thread.sleep(6000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } finally {
                            lock.unlock();
                            System.err.println("T-END-3");
                        }
                    } else {
                        System.err.println("Не очень-то и нужно было");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
