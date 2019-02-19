package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Model.*;
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
        return quizService.save(q);
    }

    @PutMapping("/Quizzes/{QuizId}")
    public QUIZ updateQuiz(@PathVariable Long QuizId, @Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        QUIZ q = quizService.findById(QuizId);
        SYSTEM s;
        QUIZTYPE qt;

        if (parser.get("system_id") != null) {
            s = systemService.findById(Long.parseLong(parser.get("system_id").toString()));
        } else {
            s = q.getSystem();// is it really needed?
        }

        if (parser.get("quiz_type_id") != null) {
            qt = quiztypeService.findById(Long.parseLong(parser.get("quiz_type_id").toString()));
        } else {
            qt = q.getQuiztype();
        }

        q.setQuiztype(qt);
        q.setSystem(s);
        return quizService.save(q);
    }

    @DeleteMapping("/Quizzes/{QuizId}")
    public ResponseEntity<?> deleteQuiz(@PathVariable Long QuizId) {
        quizService.delete(QuizId);
        return ResponseEntity.ok().build();
    }

}
