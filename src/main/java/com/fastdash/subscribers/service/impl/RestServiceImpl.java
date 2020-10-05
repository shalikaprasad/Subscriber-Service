package com.fastdash.subscribers.service.impl;

import com.fastdash.subscribers.controller.SubscriberController;
import com.fastdash.subscribers.rest.request.MLGetSubscriberRequest;
import com.fastdash.subscribers.rest.request.Subscribers;
import com.fastdash.subscribers.service.RestService;
import com.squareup.okhttp.*;
import com.squareup.okhttp.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Service("restService")
public class RestServiceImpl implements RestService {

    private final RestTemplate restTemplate;
    private final static Logger logger = LoggerFactory.getLogger(RestServiceImpl.class);

    public RestServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public String getSubscriberListJSON(String url, String key, String value) {
        HttpStatus subscribers;
        ResponseEntity<String> response;
        logger.info(">> Start get Subscriber List");
        HttpHeaders headers = new HttpHeaders();
        if(value != ""){
            headers.add(key, value);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            response = this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        }
        else {
            headers.add(key, value);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            response = this.restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        }
        subscribers = response.getStatusCode();
        logger.info(">> Finish get Subscriber List");
        if(subscribers.value() != 200){
            logger.info(">> Fail get Subscriber List");
        }
        return response.getBody();
    }

    @Override
    public void updateMailerLiteSubscribers(String url, String key, String value, Subscribers subscribers) {
        logger.info(">> Start update MailerLite Subscribers");
        HttpStatus httpStatus;
        ResponseEntity<String> response;
        String email = subscribers.getEmail();
        String name = subscribers.getName();
        HttpHeaders headers = new HttpHeaders();
        Map<String, Object> map = new HashMap<>();
        String bodyRequest = "{\"email\":" + email + "name\":" + name + ",  \"fields\": {\"company\": \"MailerLite\"}}";
        map.put("body", bodyRequest);
        headers.add(key, value);
        headers.add("Content-Type", "application/json");
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
        response = this.restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        logger.info(">> Finish update MailerLite Subscribers");
        httpStatus = response.getStatusCode();
        if(httpStatus.value() != 200){
            logger.info(">> Fail update MailerLite Subscribers, Email: " + email);
        }
    }

    @Override
    public void createMailerLiteSubscribers(String url, String key, String value, Subscribers subscribers) {
        logger.info(">> Start create MailerLite Subscribers");
        HttpStatus httpStatus;
        ResponseEntity<String> response;
        String name = subscribers.getName();
        HttpHeaders headers = new HttpHeaders();
        Map<String, Object> map = new HashMap<>();
        String bodyRequest = "{\"type\": \"unsubscribed\", \"fields\": {\"name\": " + name + ", \"company\": \"MailerLite\"}}";
        map.put("body", bodyRequest);
        headers.add(key, value);
        headers.add("Content-Type", "application/json");
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
        response = this.restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
        logger.info(">> Finish update MailerLite Subscribers");
        httpStatus = response.getStatusCode();
        if(httpStatus.value() != 200){
            logger.info(">> Fail update MailerLite Subscribers, Name: " + name);
        }
    }

    @Override
    public void updateSendFoxSubscribers(String url, String key, String value, MLGetSubscriberRequest mlGetSubscriberRequest) {
        logger.info(">> Start update SendFox Subscribers");
        HttpStatus httpStatus;
        String email = mlGetSubscriberRequest.getEmail();
        String first_name = mlGetSubscriberRequest.getName();
        try {
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\"email\": \""+ email + "\", \"first_name\": \""+ first_name + "\"}");
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .addHeader(key, value)
                    .addHeader("content-type", "application/json")
                    .addHeader("cache-control", "no-cache")
                    .build();

            Response response = client.newCall(request).execute();
            logger.info(">> Finish update SendFox Subscribers");
            if(response.code() != 200){
                logger.info(">> Fail update MailerLite Subscribers, Email: " + email);
            }
        }catch (Exception e){
            logger.info(">> Fail update MailerLite Subscribers, Email: " + email);
        }

    }


}
