package com.learning;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppdirectApiApplicationTests {
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testSignedUrl() throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("http://targethost/homepage");
        CloseableHttpResponse response1 = httpclient.execute(httpGet);
        URL url = new URL("https://www.appdirect.com/api/integration/v1/events/dummyOrder?oauth_signature=7jUvSQsZGzWJh1OB9ys1mPYEzro%3D&oauth_consumer_key=sample-136363&oauth_version=1.0&oauth_signature_method=HMAC-SHA1&oauth_timestamp=1473769579&oauth_nonce=4429917664829230367");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        StringBuilder builder = new StringBuilder();
        builder.append(httpURLConnection.getResponseCode())
                .append(" ")
                .append(httpURLConnection.getResponseMessage())
                .append("\n");

        Map<String, List<String>> map = httpURLConnection.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() == null)
                continue;
            builder.append(entry.getKey())
                    .append(": ");

            List<String> headerValues = entry.getValue();
            Iterator<String> it = headerValues.iterator();
            if (it.hasNext()) {
                builder.append(it.next());

                while (it.hasNext()) {
                    builder.append(", ")
                            .append(it.next());
                }
            }

            builder.append("\n");
        }

        System.out.println(builder);
    }

}
