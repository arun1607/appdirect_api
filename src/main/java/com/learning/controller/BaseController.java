package com.learning.controller;

import com.learning.exception.UrlSigningException;
import com.learning.rest.ResponseDataLoader;
import com.learning.security.UrlSigner;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created by amits on 14/09/16.
 */
@Log4j2
public abstract class BaseController {


    @Autowired
    protected UrlSigner urlSigner;

    @Autowired
    protected ResponseDataLoader responseDataLoader;

    protected void loadEventData(@RequestParam("url") String eventUrl) throws UrlSigningException, IOException, JAXBException {
        String signedUrl = urlSigner.signUrl(eventUrl);
        log.info("Signed url is {} ", signedUrl);
        responseDataLoader.fetchResponse(signedUrl);
    }
}
