package com.learning.exception;

/**
 * Created by amits on 13/09/16.
 */
public class UrlSigningException extends Exception {
    public UrlSigningException(String message, Throwable cause) {
        super(message, cause);
    }

    public UrlSigningException(Throwable cause) {
        super(cause);
    }
}
