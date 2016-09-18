package com.learning.exception;

/**
 * Created by amits on 13/09/16.
 */
public class PayloadDataParsingException extends RuntimeException {
    public PayloadDataParsingException(String message, Throwable cause) {
        super(message, cause);
    }

    public PayloadDataParsingException(String message) {
        super(message);
    }
}
