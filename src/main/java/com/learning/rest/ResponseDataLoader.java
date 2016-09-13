package com.learning.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by amits on 13/09/16.
 */
@Component
@Log4j2
public class ResponseDataLoader {

    @Autowired
    private RestTemplate restTemplate;


    public void fetchResponse(String url) {
        String response = restTemplate.getForObject(url, String.class);
        log.info("Response is : {}", response);
    }

}
