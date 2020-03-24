package main.BaseClasses;

import java.util.ArrayList;

public class Response {
    private int ResponseDataId;
    private ArrayList<Integer> QuestionIds;


    public int getResponseDataId() {
        return ResponseDataId;
    }

    public void setResponseDataId(int responseDataId) {
        ResponseDataId = responseDataId;
    }

    public ArrayList<Integer> getQuestionIds() {
        return QuestionIds;
    }

    public void setQuestionIds(ArrayList<Integer> questionIds) {
        QuestionIds = questionIds;
    }
}
