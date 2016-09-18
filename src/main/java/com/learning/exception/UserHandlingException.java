package com.learning.exception;

import com.learning.controller.ResponseErrorCode;

/**
 * Created by amits on 13/09/16.
 */
public class UserHandlingException extends BaseException {
    public UserHandlingException(ResponseErrorCode responseErrorCode, String message) {
        super(responseErrorCode, message);
    }
}
