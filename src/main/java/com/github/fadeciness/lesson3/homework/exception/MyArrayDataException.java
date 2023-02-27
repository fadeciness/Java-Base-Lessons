package com.github.fadeciness.lesson3.homework.exception;

import java.util.List;

public class MyArrayDataException extends RuntimeException {

    private final List<MatrixDetailError> errors;

    public MyArrayDataException(String message, List<MatrixDetailError> errors) {
        super(message);
        this.errors = errors;
    }

    public MyArrayDataException(String message, Throwable cause, List<MatrixDetailError> errors) {
        super(message, cause);
        this.errors = errors;
    }

    public MyArrayDataException(Throwable cause, List<MatrixDetailError> errors) {
        super(cause);
        this.errors = errors;
    }

    public List<MatrixDetailError> getErrors() {
        return errors;
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();
        return message + ". Detailed errors: " + errors;
    }
}
