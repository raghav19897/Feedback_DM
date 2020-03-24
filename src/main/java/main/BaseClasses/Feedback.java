package main.BaseClasses;

import java.util.Date;

public class Feedback {
    String user;
    Date Date;
    int ResponseDataId;

    public Feedback(String user, Date Date, int ResponseDataId){
        this.user = user;
        this.Date = Date;
        this.ResponseDataId = ResponseDataId;
    }
}
