package main.BaseClasses;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class Feedback implements Serializable {
    private String user;
    private Date Date;
    private HashMap<Integer, Integer> Questions;

    public Feedback(String user, Date Date, HashMap<Integer, Integer> Questions){
        this.user = user;
        this.Date = Date;
        this.Questions = Questions;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public HashMap<Integer, Integer> getQuestions() {
        return Questions;
    }

    public void setQuestions(HashMap<Integer, Integer> questions) {
        Questions = questions;
    }
}
