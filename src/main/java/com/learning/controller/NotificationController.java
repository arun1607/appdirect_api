package com.learning.controller;

import com.learning.service.SubscriptionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amits on 12/09/16.
 */
@RestController
@RequestMapping("subscription")
@Log4j2
public class NotificationController{


    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping("create")
    public boolean subscriptionCreate(@RequestParam("url") String eventUrl) throws Exception {
        subscriptionService.create(eventUrl);
        return true;
    }


    @GetMapping("update")
    public boolean subscriptionUpdate(@RequestParam("url") String eventUrl) throws Exception {
        subscriptionService.update(eventUrl);
        return true;
    }

    @GetMapping("cancel")
    public boolean subscriptionCancel(@RequestParam("url") String eventUrl) throws Exception {
        subscriptionService.cancel(eventUrl);
        return true;
    }

    @GetMapping("status")
    public boolean subscriptionStatus(@RequestParam("url") String eventUrl) throws Exception {
        subscriptionService.status(eventUrl);
        return true;
    }
}
