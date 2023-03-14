package com.github.fadeciness.lesson7.classwork.p9_additional_themes;

public class SimpleThreadExceptions {
    public static void main(String[] args) {
        try {
            new Thread(() -> {
                int x = 10 / 0;
            }).start();
        } catch (ArithmeticException e) {
            // Данный try-catch не может перехватить исключение из другого (не main) потока
            System.out.println("Caught");
        }
    }
}
