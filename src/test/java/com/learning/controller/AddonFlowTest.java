package com.learning.controller;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

/**
 * Created by amits on 16/09/16.
 */
public class AddonFlowTest extends BaseIntegrationTest {

    @Test
    public void testAddonBind() throws Exception {
        String requestParam = "http://localhost:" + port + "/test?event_type=addon_bind";
        ResponseEntity<RestResponse> responseEntity = restTemplate.getForEntity("/addons/bind?url=" + requestParam, RestResponse.class);
        Assert.notNull(responseEntity.getBody().getAccountIdentifier());
    }
  
}
