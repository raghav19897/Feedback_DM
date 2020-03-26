package main.Controllers;

import main.JDBC.DataLink;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

    DataLink dataLink = new DataLink();

    @RequestMapping("/")
    public String admin(){
        System.out.println(dataLink.getAllQuestionsStatistics());
        return "admin";
    }


}
