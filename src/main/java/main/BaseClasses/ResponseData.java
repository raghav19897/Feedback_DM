package main.BaseClasses;

import java.util.ArrayList;

public class ResponseData {
    int ResponseDataId;
    ArrayList<Integer> Questions;

    public ResponseData(int ResponseDataId, ArrayList<Integer> Questions){
        this.ResponseDataId = ResponseDataId;
        this.Questions = Questions;
    }
}
