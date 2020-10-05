package com.fastdash.subscribers.rest.request;

import java.io.Serializable;

public class MLGetSubscriberRequest implements Serializable {

    private int id;
    private String name;
    private String email;
    private String type;
    private Fields[] fields;
    private String date_subscribe;
    private String date_unsubscribe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Fields[] getFields() {
        return fields;
    }

    public void setFields(Fields[] fields) {
        this.fields = fields;
    }

    public String getDate_subscribe() {
        return date_subscribe;
    }

    public void setDate_subscribe(String date_subscribe) {
        this.date_subscribe = date_subscribe;
    }

    public String getDate_unsubscribe() {
        return date_unsubscribe;
    }

    public void setDate_unsubscribe(String date_unsubscribe) {
        this.date_unsubscribe = date_unsubscribe;
    }
}
