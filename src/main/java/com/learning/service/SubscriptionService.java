package com.learning.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.exception.SubscriptionHandlingException;
import com.learning.exception.UrlSigningException;
import com.learning.rest.Response;
import com.learning.security.UrlSigner;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by amits on 14/09/16.
 */
@Service
@Log4j2
public class SubscriptionService {

    @Autowired
    protected UrlSigner urlSigner;

    @Autowired
    protected EventDataService eventDataService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    protected Response loadEventData(String eventUrl) throws SubscriptionHandlingException {
        try {
            String signedUrl = urlSigner.signUrl(eventUrl);
            String responseBody = eventDataService.fetchResponseBody(signedUrl);
            Response response = objectMapper.readValue(responseBody, Response.class);
            log.info("Received event data : {}", response);
            return response;
        } catch (UrlSigningException | IOException e) {
            throw new SubscriptionHandlingException("Error occurred in handling subscription", e);
        }
    }

    public void create(String eventUrl) throws SubscriptionHandlingException {
        Response response = loadEventData(eventUrl);
    }

    public void update(String eventUrl) throws SubscriptionHandlingException {
        Response response = loadEventData(eventUrl);
    }

    public void cancel(String eventUrl) throws SubscriptionHandlingException {
        Response response = loadEventData(eventUrl);
    }

    public void status(String eventUrl) throws SubscriptionHandlingException {
        Response response = loadEventData(eventUrl);
    }
}
