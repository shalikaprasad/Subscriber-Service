package com.fastdash.subscribers.rest.request;

import java.io.Serializable;

public class SFGetSubscriberRequest implements Serializable {

    private int current_page;
    private SendFoxContact[] data;

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public SendFoxContact[] getData() {
        return data;
    }

    public void setData(SendFoxContact[] data) {
        this.data = data;
    }
}
