package com.fastdash.subscribers.rest.request;

import java.io.Serializable;

public class SendFoxContact implements Serializable {
    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String unsubscribed_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUnsubscribed_at() {
        return unsubscribed_at;
    }

    public void setUnsubscribed_at(String unsubscribed_at) {
        this.unsubscribed_at = unsubscribed_at;
    }
}
