package com.tomwey2.calculator.exception;

public class OverflowException extends RuntimeException {
    public OverflowException(String message) {
        super(message);
    }
}