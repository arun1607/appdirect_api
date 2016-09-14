package com.learning.exception;

/**
 * Created by amits on 13/09/16.
 */
public class UserHandlingException extends Exception {
    public UserHandlingException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserHandlingException(Throwable cause) {
        super(cause);
    }
}
