package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.edu.tedu.anatomyweb.Model.QUIZTYPE;
import tr.edu.tedu.anatomyweb.Service.IQuiztypeService;
import tr.edu.tedu.anatomyweb.Service.QuiztypeService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class HelloController  {

    @Autowired
    IQuiztypeService quiztypeService;


    @RequestMapping("/")
    String home() {
        return "Hello World from the server!";
    }


    @RequestMapping("/quiztypes")
    List<String> quizTypes() {

        ArrayList<String> str= new ArrayList<>();
        for (QUIZTYPE q:quiztypeService.findAll()
        ) {
            str.add(q.toString());
        }
        return str;
    }
}
