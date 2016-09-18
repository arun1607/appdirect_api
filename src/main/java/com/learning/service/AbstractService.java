package com.learning.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.exception.EventDataHandlingException;
import com.learning.rest.EventWrapper;
import com.learning.utils.UrlSigner;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * Created by amits on 15/09/16.
 */
@Log4j2
public abstract class AbstractService {
    @Autowired
    protected UrlSigner urlSigner;

    @Autowired
    protected EventDataService eventDataService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    protected EventWrapper loadEventData(String eventUrl) {
        try {
            String signedUrl = urlSigner.signUrl(eventUrl);
            String responseBody = eventDataService.fetchResponseBody(signedUrl);
            log.info("Response body is {}", responseBody);
            EventWrapper eventWrapper = objectMapper.readValue(responseBody, EventWrapper.class);
            log.info("Received event data : {}", eventWrapper);
            return eventWrapper;
        } catch (IOException e) {
            throw new EventDataHandlingException("Error occurred in handling event for event url : " + eventUrl, e);
        }
    }
}
