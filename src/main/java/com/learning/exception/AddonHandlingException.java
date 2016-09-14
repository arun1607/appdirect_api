package com.learning.exception;

/**
 * Created by amits on 13/09/16.
 */
public class AddonHandlingException extends Exception {
    public AddonHandlingException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddonHandlingException(Throwable cause) {
        super(cause);
    }
}
