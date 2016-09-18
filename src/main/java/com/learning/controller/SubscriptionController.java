package com.learning.controller;

import com.learning.service.SubscriptionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Created by amits on 12/09/16.
 */
@RestController
@RequestMapping("subscription")
@Log4j2
public class SubscriptionController extends BaseController {


    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping("create")
    public Response subscriptionCreate(@RequestParam("url") String eventUrl) throws Exception {
        Response response = validateRequestParams(eventUrl);
        if (Objects.isNull(response)) {
            response = subscriptionService.create(eventUrl);
        }
        return response;
    }


    @GetMapping("update")
    public Response subscriptionUpdate(@RequestParam("url") String eventUrl) throws Exception {
        Response response = validateRequestParams(eventUrl);
        if (Objects.isNull(response)) {
            response = subscriptionService.update(eventUrl);
        }
        return response;
    }

    @GetMapping("cancel")
    public Response subscriptionCancel(@RequestParam("url") String eventUrl) throws Exception {
        Response response = validateRequestParams(eventUrl);
        if (Objects.isNull(response)) {
            response = subscriptionService.cancel(eventUrl);
        }
        return response;
    }

    @GetMapping("status")
    public Response subscriptionStatus(@RequestParam("url") String eventUrl) throws Exception {
        Response response = validateRequestParams(eventUrl);
        if (Objects.isNull(response)) {
            response = subscriptionService.status(eventUrl);
        }
        return response;
    }
}
