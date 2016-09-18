package com.learning.exception;

import com.learning.controller.ResponseErrorCode;
import oauth.signpost.exception.OAuthException;

/**
 * Created by amits on 13/09/16.
 */
public class UrlSigningException extends BaseException {
    public UrlSigningException(ResponseErrorCode responseErrorCode, String message, OAuthException e) {
        super(responseErrorCode, message);
    }
}
