package com.learning.utils;


import com.learning.controller.ResponseErrorCode;
import com.learning.exception.PayloadDataParsingException;
import org.apache.commons.lang3.StringUtils;

public final class Utils {
    //--------------------------------------------------------------------------------------------------
    public static String extractOpenId(String url) {
        String openId = StringUtils.substringAfterLast(url, "/");
        if (StringUtils.isBlank(openId))
            throw new PayloadDataParsingException(ResponseErrorCode.INVALID_RESPONSE, "OpenId is null or empty.");

        return openId;
    }
}
