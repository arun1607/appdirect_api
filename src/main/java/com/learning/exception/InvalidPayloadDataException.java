package com.learning.exception;

import com.learning.controller.ResponseErrorCode;

/**
 * Created by amits on 13/09/16.
 */
public class InvalidPayloadDataException extends BaseException {
    public InvalidPayloadDataException(ResponseErrorCode responseErrorCode, String message) {
        super(responseErrorCode, message);
    }
}
