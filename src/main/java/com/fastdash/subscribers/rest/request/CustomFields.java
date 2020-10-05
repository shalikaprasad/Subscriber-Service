package com.fastdash.subscribers.rest.request;

import java.io.Serializable;

public class CustomFields implements Serializable {
    private String CustomFieldID;
    private String Name;
    private String Value;

    public String getCustomFieldID() {
        return CustomFieldID;
    }

    public void setCustomFieldID(String customFieldID) {
        CustomFieldID = customFieldID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
