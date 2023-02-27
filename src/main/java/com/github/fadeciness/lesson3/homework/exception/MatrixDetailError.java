package com.github.fadeciness.lesson3.homework.exception;

public class MatrixDetailError {

    private final int row;
    private final int col;
    private final String message;

    public MatrixDetailError(int row, int col, String message) {
        this.row = row;
        this.col = col;
        this.message = message;
    }

    @Override
    public String toString() {
        return "MatrixDetailError{" +
                "row=" + row +
                ", col=" + col +
                ", message=" + message +
                '}';
    }
}
