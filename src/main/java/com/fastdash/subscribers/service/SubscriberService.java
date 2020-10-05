package com.fastdash.subscribers.service;

import com.fastdash.subscribers.models.Roles;
import com.fastdash.subscribers.models.Users;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * Created by Prasad on 12/15/19.
 */
public interface SubscriberService {

    public String updateMoosendMailerLiteSubscribers();

    public String updateSendFoxMailerLiteSubscribers();

}

