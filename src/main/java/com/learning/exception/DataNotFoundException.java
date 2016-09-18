package com.learning.exception;

/**
 * Created by amits on 13/09/16.
 */
public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataNotFoundException(String message) {
        super(message);
    }
}
