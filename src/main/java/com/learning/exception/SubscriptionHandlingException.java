package com.learning.exception;

/**
 * Created by amits on 13/09/16.
 */
public class SubscriptionHandlingException extends Exception {
    public SubscriptionHandlingException(String message, Throwable cause) {
        super(message, cause);
    }

    public SubscriptionHandlingException(Throwable cause) {
        super(cause);
    }
}
