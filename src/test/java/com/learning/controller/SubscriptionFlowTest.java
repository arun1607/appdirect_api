package com.learning.controller;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

/**
 * Created by amits on 16/09/16.
 */
public class SubscriptionFlowTest extends BaseIntegrationTest {

    @Test
    public void testSubscriptionOrder() throws Exception {
        String requestParam = "http://localhost:" + port + "/test?event_type=subscription_order";
        ResponseEntity<RestResponse> responseEntity = restTemplate.getForEntity("/subscription/create?url=" + requestParam, RestResponse.class);
        Assert.notNull(responseEntity.getBody());
    }


}
