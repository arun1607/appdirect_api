package com.learning.rest;

import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by amits on 13/09/16.
 */
@Component
@Log4j2
public class ResponseDataLoader {


    public void fetchResponse(String url) throws IOException, JAXBException {

        CloseableHttpClient httpclient = HttpClients.createDefault();

        try {
            HttpGet httpget = new HttpGet(url);
            httpget.setHeader("Accept", "application/json");
            httpget.setHeader("Content-type", "application/json");
            System.out.println("Executing request " + httpget.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(httpget, responseHandler);
            JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Response response = (Response) jaxbUnmarshaller.unmarshal(new StringReader(responseBody));
            log.info("Response is : {}", response);
        } finally {
            httpclient.close();
        }
    }

}
