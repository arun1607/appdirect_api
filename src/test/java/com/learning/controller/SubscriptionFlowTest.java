package com.learning.controller;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

/**
 * Created by amits on 16/09/16.
 */
@Log4j2
public class SubscriptionFlowTest extends BaseIntegrationTest {

    @Test
    public void testSubscriptionOrder() throws Exception {
        String requestParam = "http://localhost:" + port + "/test?event_type=subscription_order";
        ResponseEntity<RestResponse> responseEntity = restTemplate.getForEntity("/subscription/create?url=" + requestParam, RestResponse.class);
        log.info("Response body is {}", responseEntity.getBody());
        Assert.notNull(responseEntity.getBody());
    }


}
