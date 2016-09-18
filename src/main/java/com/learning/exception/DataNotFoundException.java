package com.learning.exception;

import com.learning.controller.ResponseErrorCode;

/**
 * Created by amits on 13/09/16.
 */
public class DataNotFoundException extends BaseException {
    public DataNotFoundException(ResponseErrorCode responseErrorCode, String message) {
        super(responseErrorCode, message);
    }
}
