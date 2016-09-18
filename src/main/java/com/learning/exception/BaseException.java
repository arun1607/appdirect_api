package com.learning.exception;

import com.learning.controller.ResponseErrorCode;
import lombok.Getter;

/**
 * Created by amits on 19/09/16.
 */
@Getter
public class BaseException extends RuntimeException {

    private ResponseErrorCode responseErrorCode;

    public BaseException(ResponseErrorCode responseErrorCode, String message) {
        super(message);
        this.responseErrorCode = responseErrorCode;
    }
}
