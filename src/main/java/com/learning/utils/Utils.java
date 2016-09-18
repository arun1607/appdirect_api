package com.learning.utils;


import com.learning.exception.PayloadDataParsingException;
import org.apache.commons.lang3.StringUtils;

public final class Utils {
    //--------------------------------------------------------------------------------------------------
    public static String extractOpenId(String url) {
        String openId = StringUtils.substringAfterLast(url, "/");
        if (StringUtils.isBlank(openId))
            throw new PayloadDataParsingException("OpenId is null or empty.");

        return openId;
    }
}
