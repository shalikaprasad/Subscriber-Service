package com.fastdash.subscribers.service;

import com.fastdash.subscribers.models.Roles;
import com.fastdash.subscribers.models.Users;
import com.fastdash.subscribers.rest.request.MLGetSubscriberRequest;
import com.fastdash.subscribers.rest.request.MSGetSubscriberRequest;
import com.fastdash.subscribers.rest.request.SendFoxContact;
import com.fastdash.subscribers.rest.request.Subscribers;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Prasad on 12/15/19.
 */
public interface RestService {

    public String getSubscriberListJSON(String url, String key, String value);

    public void updateMailerLiteSubscribers(String url, String key, String value, Subscribers subscribers);

    public void createMailerLiteSubscribers(String url, String key, String value, Subscribers subscribers);

    public void updateSendFoxSubscribers(String url, String key, String value, MLGetSubscriberRequest mlGetSubscriberRequest);
}

