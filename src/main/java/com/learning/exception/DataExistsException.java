package com.learning.exception;

/**
 * Created by amits on 13/09/16.
 */
public class DataExistsException extends RuntimeException {
    public DataExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataExistsException(String message) {
        super(message);
    }
}
