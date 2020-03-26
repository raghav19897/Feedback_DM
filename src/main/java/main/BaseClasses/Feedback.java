package main.BaseClasses;

import java.sql.Date;
import java.util.HashMap;

public class Feedback {
    private String user;
    private Date Date;
    private HashMap<Integer, Integer> Questions;

    public Feedback(){}

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

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        this.Date = date;
    }

    public HashMap<Integer, Integer> getQuestions() {
        return Questions;
    }

    public void setQuestions(HashMap<Integer, Integer> questions) {
        this.Questions = questions;
    }
}
