package com.fastdash.subscribers.rest.request;

import java.io.Serializable;

public class MSGetSubscriberContext implements Serializable {
    private Paging Paging;
    private Subscribers[] Subscribers;

    public com.fastdash.subscribers.rest.request.Paging getPaging() {
        return Paging;
    }

    public void setPaging(com.fastdash.subscribers.rest.request.Paging paging) {
        Paging = paging;
    }

    public com.fastdash.subscribers.rest.request.Subscribers[] getSubscribers() {
        return Subscribers;
    }

    public void setSubscribers(com.fastdash.subscribers.rest.request.Subscribers[] subscribers) {
        Subscribers = subscribers;
    }
}
