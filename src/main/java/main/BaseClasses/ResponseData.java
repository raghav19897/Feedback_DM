package main.BaseClasses;

import java.util.HashMap;

public class ResponseData {
    private String user;
    private int ResponseDataId;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getResponseDataId() {
        return ResponseDataId;
    }

    public void setResponseDataId(int responseDataId) {
        ResponseDataId = responseDataId;
    }
}
