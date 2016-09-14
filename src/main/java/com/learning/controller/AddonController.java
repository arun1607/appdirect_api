package com.learning.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amits on 14/09/16.
 */
@RestController
@RequestMapping("addons")
@Log4j2
public class AddonController extends BaseController {

    @GetMapping("order")
    public boolean addonOrder(@RequestParam("url") String eventUrl) throws Exception {
        loadEventData(eventUrl);
        return true;
    }


    @GetMapping("change")
    public boolean addonChange(@RequestParam("url") String eventUrl) throws Exception {
        loadEventData(eventUrl);
        return true;
    }

    @GetMapping("cancel")
    public boolean addonCancel(@RequestParam("url") String eventUrl) throws Exception {
        loadEventData(eventUrl);
        return true;
    }

    @GetMapping("bind")
    public boolean addonBind(@RequestParam("url") String eventUrl) throws Exception {
        loadEventData(eventUrl);
        return true;
    }

    @GetMapping("unbind")
    public boolean addonUnbind(@RequestParam("url") String eventUrl) throws Exception {
        loadEventData(eventUrl);
        return true;
    }
}
