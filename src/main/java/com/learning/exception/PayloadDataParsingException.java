package com.learning.exception;

import com.learning.controller.ResponseErrorCode;

/**
 * Created by amits on 13/09/16.
 */
public class PayloadDataParsingException extends BaseException {
    public PayloadDataParsingException(ResponseErrorCode responseErrorCode, String message) {
        super(responseErrorCode, message);
    }
}
