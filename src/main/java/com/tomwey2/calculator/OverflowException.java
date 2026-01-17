package com.tomwey2.calculator;

public class OverflowException extends RuntimeException {
    public OverflowException(String message) {
        super(message);
    }
}