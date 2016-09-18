package com.learning.exception;

import com.learning.controller.ResponseErrorCode;

import java.io.IOException;

/**
 * Created by amits on 13/09/16.
 */
public class EventDataHandlingException extends BaseException {
    public EventDataHandlingException(ResponseErrorCode responseErrorCode, String message, IOException e) {
        super(responseErrorCode, message);
    }
}
