package com.learning.controller;

import com.learning.service.UserService;
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
@RequestMapping("user")
@Log4j2
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("assignment")
    public boolean userAssignment(@RequestParam("url") String eventUrl) throws Exception {
        userService.assignment(eventUrl);
        return true;
    }

    @GetMapping("unassignment")
    public boolean userUnassignment(@RequestParam("url") String eventUrl) throws Exception {
        userService.unassignment(eventUrl);
        return true;
    }


}
