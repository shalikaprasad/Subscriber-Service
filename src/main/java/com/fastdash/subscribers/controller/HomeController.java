package com.fastdash.subscribers.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Prasad on 12/15/19.
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/")
@Api(value = "home", tags = "Home Controller")
public class HomeController {

    private final static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping(value = "/")
    public String createUser(@RequestParam("id") String id) {
        logger.info(">> Home Page Begin  with " + id);
        return  "Home Page Begin  with " + id;
    }
}
