package com.learning.exception;

/**
 * Created by amits on 13/09/16.
 */
public class EventDataHandlingException extends RuntimeException {
    public EventDataHandlingException(String message, Throwable cause) {
        super(message, cause);
    }
}
