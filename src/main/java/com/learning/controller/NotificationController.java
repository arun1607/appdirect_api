package com.learning.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by amits on 12/09/16.
 */
@RestController
@RequestMapping("subscription")
@Log4j2
public class NotificationController {

    @GetMapping("create")
    public boolean createSubscription(@RequestParam Map<String, String> allRequestParams) {
        allRequestParams.forEach((key, val) -> log.info("Key is : {} and value is : {}", key, val));
        return true;
    }
}
