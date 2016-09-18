package com.learning.exception;

import com.learning.controller.ResponseErrorCode;

/**
 * Created by amits on 13/09/16.
 */
public class DataExistsException extends BaseException {
    public DataExistsException(ResponseErrorCode responseErrorCode, String message) {
        super(responseErrorCode, message);
    }
}
