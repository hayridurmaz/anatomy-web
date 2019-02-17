package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.edu.tedu.anatomyweb.Model.QUIZ;
import tr.edu.tedu.anatomyweb.Model.QUIZTYPE;
import tr.edu.tedu.anatomyweb.Service.IQuizService;
import tr.edu.tedu.anatomyweb.Service.IQuiztypeService;
import java.util.List;

@CrossOrigin
@RestController
public class HelloController  {

    @Autowired
    IQuiztypeService quiztypeService;
    @Autowired
    IQuizService quizService;

    @RequestMapping("/")
    String home() {
        return "Hello World from the server!";
    }


    @GetMapping(("/quiztypes"))
    List<QUIZTYPE> quizTypes() {
        List<QUIZTYPE> quiztypes = (List<QUIZTYPE>) quiztypeService.findAll();
        return quiztypes;
    }

    @GetMapping("/quizzes")
    List<QUIZ> quizzes(){
        return quizService.findAll();
    }

}
