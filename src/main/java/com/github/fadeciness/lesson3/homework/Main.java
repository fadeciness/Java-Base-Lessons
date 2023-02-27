package com.github.fadeciness.lesson3.homework;

import com.github.fadeciness.lesson3.homework.exception.MyArrayDataException;
import com.github.fadeciness.lesson3.homework.exception.MyArraySizeException;
import com.github.fadeciness.lesson3.homework.service.MyMatrixService;

public class Main {
    public static void main(String[] args) {
        String[][] myMatrix = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        long totalSum;
        try {
            totalSum = MyMatrixService.elementsSum(myMatrix);
            System.out.println("The program is completed with the result: " + totalSum);
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println("The program is terminated due to the fact that: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("The program is terminated due to an unknown error.");
            throw new RuntimeException(ex);
        }
    }
}
