package com.learning.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.exception.UrlSigningException;
import com.learning.exception.UserHandlingException;
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
public class UserService {

    @Autowired
    protected UrlSigner urlSigner;

    @Autowired
    protected EventDataService eventDataService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    protected Response loadEventData(String eventUrl) throws UserHandlingException {
        try {
            String signedUrl = urlSigner.signUrl(eventUrl);
            String responseBody = eventDataService.fetchResponseBody(signedUrl);
            Response response = objectMapper.readValue(responseBody, Response.class);
            log.info("Received event data : {}", response);
            return response;
        } catch (UrlSigningException | IOException e) {
            throw new UserHandlingException("Error occurred in handling subscription", e);
        }
    }

    public void assignment(String eventUrl) throws UserHandlingException {
        Response response = loadEventData(eventUrl);
    }

    public void unassignment(String eventUrl) throws UserHandlingException {
        Response response = loadEventData(eventUrl);
    }
}
