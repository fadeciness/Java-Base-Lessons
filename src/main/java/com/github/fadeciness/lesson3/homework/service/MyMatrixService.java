package com.github.fadeciness.lesson3.homework.service;

import com.github.fadeciness.lesson3.homework.exception.MatrixDetailError;
import com.github.fadeciness.lesson3.homework.exception.MyArrayDataException;
import com.github.fadeciness.lesson3.homework.exception.MyArraySizeException;

import java.util.ArrayList;

public class MyMatrixService {

    private static final int ROWS_COUNT = 4;
    private static final int COLUMNS_COUNT = 4;

    public static long elementsSum(String[][] matrix) {
        validate(matrix);
        int[][] matrixInt = transform(matrix);
        return sum(matrixInt);
    }

    private static void validate(String[][] matrix) {
        if (matrix.length != ROWS_COUNT) {
            throw new MyArraySizeException("The number of rows in the matrix does not match the required value: " + ROWS_COUNT);
        }
        for (String[] row : matrix) {
            if (row.length != COLUMNS_COUNT) {
                throw new MyArraySizeException("The number of columns in the matrix does not match the required value: " + COLUMNS_COUNT);
            }
        }
    }

    private static int[][] transform(String[][] matrix) {
        int[][] res = new int[ROWS_COUNT][COLUMNS_COUNT];
        ArrayList<MatrixDetailError> errors = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String currEl = matrix[row][col];
                try {
                    int currElInt = Integer.parseInt(currEl);
                    res[row][col] = currElInt;
                } catch (NumberFormatException ex) {
                    errors.add(new MatrixDetailError(row, col, "Conversion to int is not possible " + ex.getMessage()));
                }
            }
        }
        if (!errors.isEmpty()) {
            throw new MyArrayDataException("The data in the matrix does not correspond to the numeric format", errors);
        }
        return res;
    }

    private static long sum(int[][] matrix) {
        long sum = 0;
        for (int[] row : matrix) {
            for (int col : row) {
                sum += col;
            }
        }
        return sum;
    }

}
