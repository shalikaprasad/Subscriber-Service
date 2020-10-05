package com.fastdash.subscribers.rest.request;

import java.io.Serializable;

public class MSGetSubscriberRequest implements Serializable {

    private int Code;
    private String Error;
    private MSGetSubscriberContext Context;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getError() {
        return Error;
    }

    public void setError(String error) {
        Error = error;
    }

    public MSGetSubscriberContext getContext() {
        return Context;
    }

    public void setContext(MSGetSubscriberContext context) {
        Context = context;
    }
}
