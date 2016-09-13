package com.learning.controller;

import com.learning.exception.UrlSigningException;
import com.learning.rest.ResponseDataLoader;
import com.learning.security.UrlSigner;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by amits on 12/09/16.
 */
@RestController
@RequestMapping("subscription")
@Log4j2
public class NotificationController {

    @Autowired
    private UrlSigner urlSigner;

    @Autowired
    private ResponseDataLoader responseDataLoader;

    @GetMapping("create")
    public boolean subscriptionCreate(@RequestParam("url") String eventUrl) throws UrlSigningException {
        String signedUrl = urlSigner.signUrl(eventUrl);
        log.info("Signed url is {} ", signedUrl);
        responseDataLoader.fetchResponse(signedUrl);

        return true;
    }

    @GetMapping("update")
    public boolean subscriptionUpdate(@RequestParam Map<String, String> allRequestParams) {
        allRequestParams.forEach((key, val) -> log.info("Key is : {} and value is : {}", key, val));
        return true;
    }

    @GetMapping("cancel")
    public boolean subscriptionCancel(@RequestParam Map<String, String> allRequestParams) {
        allRequestParams.forEach((key, val) -> log.info("Key is : {} and value is : {}", key, val));
        return true;
    }

    @GetMapping("status")
    public boolean subscriptionStatus(@RequestParam Map<String, String> allRequestParams) {
        allRequestParams.forEach((key, val) -> log.info("Key is : {} and value is : {}", key, val));
        return true;
    }

    @GetMapping("addons")
    public boolean subscriptionAddOns(@RequestParam Map<String, String> allRequestParams) {
        allRequestParams.forEach((key, val) -> log.info("Key is : {} and value is : {}", key, val));
        return true;
    }
}
