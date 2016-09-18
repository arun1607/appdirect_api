package com.learning.exception;

/**
 * Created by amits on 13/09/16.
 */
public class InvalidPayloadDataException extends RuntimeException {
    public InvalidPayloadDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPayloadDataException(String message) {
        super(message);
    }
}
