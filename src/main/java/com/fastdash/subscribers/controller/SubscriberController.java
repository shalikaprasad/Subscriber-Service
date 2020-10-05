package com.fastdash.subscribers.controller;

import com.fastdash.subscribers.rest.response.ResponseWrapper;
import com.fastdash.subscribers.service.SubscriberService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Prasad on 12/15/19.
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/api/subscriber")
@Api(value = "subscriber", tags = "Subscriber Controller")
public class SubscriberController {

    @Autowired
    private SubscriberService subscriberService;

    private final static Logger logger = LoggerFactory.getLogger(SubscriberController.class);

    @GetMapping(value = "/updateMoosendMailerLiteSubscribers")
    public ResponseWrapper updateMoosendMailerLiteSubscribers() {
        logger.info(">> Start");
        try {
            logger.info(">> Successfully Update Moosend and Mailer Lite Subscribers");
            return ResponseWrapper.success(subscriberService.updateMoosendMailerLiteSubscribers());
        }catch (Exception e){
            return ResponseWrapper.fail();
        }
    }

    @GetMapping(value = "/updateSendFoxMailerLiteSubscribers")
    public ResponseWrapper updateSendFoxMailerLiteSubscribers() {
        logger.info(">> Start");
        try {
            logger.info(">> Successfully Update Moosend and Mailer Lite Subscribers");
            return ResponseWrapper.success(subscriberService.updateSendFoxMailerLiteSubscribers());
        }catch (Exception e){
            return ResponseWrapper.fail();
        }
    }
}
