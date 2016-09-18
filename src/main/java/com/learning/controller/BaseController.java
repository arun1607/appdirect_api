package com.learning.controller;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by amits on 15/09/16.
 */
public class BaseController {

    protected Response validateRequestParams(String url) {
        Response response = null;
        if (StringUtils.isBlank(url) || StringUtils.isBlank(StringUtils.substringAfterLast(url, "/"))) {
            return Response.failure(ResponseErrorCode.INVALID_RESPONSE, "Invalid url");
        }
        return response;
    }
}
