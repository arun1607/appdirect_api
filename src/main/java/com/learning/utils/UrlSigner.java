package com.learning.utils;

import com.learning.controller.ResponseErrorCode;
import com.learning.exception.UrlSigningException;
import lombok.extern.log4j.Log4j2;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.signature.QueryStringSigningStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by amits on 13/09/16.
 */
@Log4j2
@Component
public class UrlSigner {

    @Value("${consumer.key}")
    private String consumerKey;

    @Value("${consumer.secret}")
    private String consumerSecret;

    public String signUrl(String originalUrl) {
        log.info("Input url : {} ", originalUrl);
        OAuthConsumer consumer = new DefaultOAuthConsumer(consumerKey, consumerSecret);
        consumer.setSigningStrategy(new QueryStringSigningStrategy());
        try {
            return consumer.sign(originalUrl);
        } catch (OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException e) {
            throw new UrlSigningException(ResponseErrorCode.UNKNOWN_ERROR, "Problem occurred in signing", e);
        }
    }
}
