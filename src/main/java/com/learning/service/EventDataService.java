package com.learning.service;

import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by amits on 13/09/16.
 */
@Component
@Log4j2
public class EventDataService {
    @Autowired
    private CloseableHttpClient client;

    String fetchResponseBody(String url) throws IOException {

        HttpGet httpget = new HttpGet(url);
        httpget.setHeader("Accept", "application/json");
        httpget.setHeader("Content-type", "application/json");
        // Create a custom response handler
        ResponseHandler<String> responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                String body = entity != null ? EntityUtils.toString(entity) : null;
                log.info("Response body is : {}", body);
                return body;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        };
        return client.execute(httpget, responseHandler);
    }

}
