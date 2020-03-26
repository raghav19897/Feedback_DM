package main.Controllers;

import main.BaseClasses.Feedback;
import main.JDBC.DataLink;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private DataLink dataLink = new DataLink();
    private int ResponseDataId = 101;
    private int QuestionId = 101;

    @CrossOrigin
    @PostMapping(value = "/SendFullFeedback")
    public Feedback addFullFeedback(@RequestBody Feedback currFeedback){
        dataLink.insertIntoResponseData(currFeedback.getUser(), ResponseDataId);

        String QuestionIds = "";

        Set<Integer> allKeys = getAllKeysFromHashMap(currFeedback);
        for (Integer currentKey : allKeys) {
            dataLink.insertIntoQuestions(QuestionId, currentKey, currFeedback.getQuestions().get(currentKey));
            QuestionIds += QuestionId + ";";
            QuestionId++;
        }

        dataLink.insertIntoResponse(ResponseDataId, QuestionIds.substring(0, QuestionIds.length()-1));

        ResponseDataId++;
        return currFeedback;
    }

    @CrossOrigin
    @GetMapping("/GetAllQuestions")
    public ArrayList<String> getQuestions(){
        return dataLink.getAllQuestions();
    }

    private Set<Integer> getAllKeysFromHashMap(Feedback feedbackObj){ return feedbackObj.getQuestions().keySet(); }
}
