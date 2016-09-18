package com.learning.exception;

import com.learning.controller.ResponseErrorCode;

/**
 * Created by amits on 13/09/16.
 */
public class AddonHandlingException extends BaseException {

    public AddonHandlingException(ResponseErrorCode responseErrorCode, String message) {
        super(responseErrorCode, message);
    }
}
