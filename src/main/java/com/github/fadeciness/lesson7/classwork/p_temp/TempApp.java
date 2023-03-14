package com.github.fadeciness.lesson7.classwork.p_temp;

import java.util.concurrent.atomic.AtomicInteger;

public class TempApp {
    public static void main(String[] args) {
        /*
            Vector<?> - синхронизированный устаревший класс
            Hashtable - синхронизированный устаревший класс
            - блокировка на всю таблицу для всех операций
            (хотя читать можно было бы параллельно)

            ConcurrentHashMap - нет блокировки на чтение
            блокировка на запись - блокируется только та ячейка куда осуществляется запись

            Collections.synchronizedList()
            Collections.synchronizedMap()
            - делают синхронизированную обёртку над обычным листом/мапой
            но хуже ConcurrentHashMap

            CopyOnWriteArrayList()
            - на каждую новую вставку создает новый объект
            - поток который добавил элемент видит новый объект
            - старые потоки видят каждый свою версию

            ArrayBlockingQueue
            -
         */


        AtomicInteger ai = new AtomicInteger(10); // атомарные операции

    }
}
