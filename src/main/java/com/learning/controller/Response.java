package com.learning.controller;

import lombok.Getter;
import lombok.ToString;

/**
 * Created by amits on 15/09/16.
 */
@ToString
@Getter
public class Response {

    private String accountIdentifier;
    private ResponseErrorCode errorCode;
    private String message;
    private boolean success;

    private Response(ResponseErrorCode errorCode, String message, boolean success) {
        this.errorCode = errorCode;
        this.message = message;
        this.success = success;
    }

    private Response(String accountIdentifier, boolean success) {

        this.accountIdentifier = accountIdentifier;
        this.success = success;
    }

    public static Response failure(ResponseErrorCode responseErrorCode, String message) {
        return new Response(responseErrorCode, message, false);
    }

    public static Response success(String accountIdentifier) {
        return new Response(accountIdentifier, true);
    }
}
