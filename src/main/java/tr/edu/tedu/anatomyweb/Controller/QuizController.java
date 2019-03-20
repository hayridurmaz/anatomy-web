package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Model.QUIZ;
import tr.edu.tedu.anatomyweb.Model.QUIZTYPE;
import tr.edu.tedu.anatomyweb.Model.SYSTEM;
import tr.edu.tedu.anatomyweb.Service.IQuizService;
import tr.edu.tedu.anatomyweb.Service.IQuiztypeService;
import tr.edu.tedu.anatomyweb.Service.ISystemService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class QuizController {

    @Autowired
    IQuizService quizService;
    @Autowired
    ISystemService systemService;
    @Autowired
    IQuiztypeService quiztypeService;

    @GetMapping("/Quizzes")
    List<QUIZ> getQuizzes() {
        return quizService.findAll();
    }

    @GetMapping(("/Quizzes/{QuizId}"))
    QUIZ getQuizById(@PathVariable Long QuizId) {
        QUIZ quiz = quizService.findById(QuizId);
        return quiz;
    }

    @PostMapping("/Quizzes")
    public QUIZ createQuiz(@Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        SYSTEM s = systemService.findById(Long.parseLong(parser.get("system_id").toString()));
        QUIZTYPE qt = quiztypeService.findById(Long.parseLong(parser.get("quiz_type_id").toString()));

        QUIZ q = new QUIZ();
        q.setQuiztype(qt);
        q.setSystem(s);
        q.setHeader(parser.get("header").toString());
        return quizService.save(q);
    }

    @PutMapping("/Quizzes/{QuizId}")
    public QUIZ updateQuiz(@PathVariable Long QuizId, @Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        QUIZ q = quizService.findById(QuizId);

        if (parser.get("system_id") != null) {
            SYSTEM s = systemService.findById(Long.parseLong(parser.get("system_id").toString()));
            q.setSystem(s);
        }
        if (parser.get("quiz_type_id") != null) {
            QUIZTYPE qt = quiztypeService.findById(Long.parseLong(parser.get("quiz_type_id").toString()));
            q.setQuiztype(qt);
        }
        if (parser.get("header") != null){
            q.setHeader(parser.get("header").toString());
        }

        return quizService.save(q);
    }

    @DeleteMapping("/Quizzes/{QuizId}")
    public String deleteQuiz(@PathVariable Long QuizId) {
        return quizService.delete(QuizId);
    }

}
