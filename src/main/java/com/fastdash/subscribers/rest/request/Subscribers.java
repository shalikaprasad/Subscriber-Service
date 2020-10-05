package com.fastdash.subscribers.rest.request;

import java.io.Serializable;

public class Subscribers implements Serializable {
    private String ID;
    private String Name;
    private String Email;
    private String CreatedOn;
    private String UpdatedOn;
    private String UnsubscribedOn;
    private String UnsubscribedFromID;
    private int SubscribeType;
    private int SubscribeMethod;
    private CustomFields[] CustomFields;
    private String RemovedOn;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(String createdOn) {
        CreatedOn = createdOn;
    }

    public String getUpdatedOn() {
        return UpdatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        UpdatedOn = updatedOn;
    }

    public String getUnsubscribedOn() {
        return UnsubscribedOn;
    }

    public void setUnsubscribedOn(String unsubscribedOn) {
        UnsubscribedOn = unsubscribedOn;
    }

    public String getUnsubscribedFromID() {
        return UnsubscribedFromID;
    }

    public void setUnsubscribedFromID(String unsubscribedFromID) {
        UnsubscribedFromID = unsubscribedFromID;
    }

    public int getSubscribeType() {
        return SubscribeType;
    }

    public void setSubscribeType(int subscribeType) {
        SubscribeType = subscribeType;
    }

    public int getSubscribeMethod() {
        return SubscribeMethod;
    }

    public void setSubscribeMethod(int subscribeMethod) {
        SubscribeMethod = subscribeMethod;
    }

    public com.fastdash.subscribers.rest.request.CustomFields[] getCustomFields() {
        return CustomFields;
    }

    public void setCustomFields(com.fastdash.subscribers.rest.request.CustomFields[] customFields) {
        CustomFields = customFields;
    }

    public String getRemovedOn() {
        return RemovedOn;
    }

    public void setRemovedOn(String removedOn) {
        RemovedOn = removedOn;
    }
}
