package main.Controllers;

import main.BaseClasses.Feedback;
import main.BaseClasses.Questions;
import main.BaseClasses.Response;
import main.BaseClasses.ResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.HashMap;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    ResponseData currResponseData;
    Response currResponse;
    Questions currQuestions;
    int ResponseDataId;
    @PostMapping("/SendFullFeedback")
    public Feedback addFullFeedback(@RequestBody Feedback currFeedback){
        return currFeedback;
    }

    @GetMapping("/GetFeedback")
    public Feedback getFeedback(){
        HashMap<Integer, Integer> Q = new HashMap<>();
        Q.put(1, 100);
        Q.put(2, 101);
        Q.put(3, 102);
        Q.put(4, 103);
        Q.put(5, 104);
        return new Feedback("Raghav", new Date(), Q);
    }
}
