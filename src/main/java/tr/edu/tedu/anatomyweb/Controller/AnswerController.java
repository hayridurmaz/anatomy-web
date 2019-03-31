package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Model.ANSWER;
import tr.edu.tedu.anatomyweb.Model.QUESTION;
import tr.edu.tedu.anatomyweb.Service.IAnswerService;
import tr.edu.tedu.anatomyweb.Service.IQuestionService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class AnswerController {

    @Autowired
    IAnswerService answerService;
    @Autowired
    IQuestionService questionService;

    @GetMapping("/Answers")
    List<ANSWER> getAnswers() {
        return answerService.findAll();
    }

    @GetMapping(("/Answers/{AnswerId}"))
    ANSWER getAnswerById(@PathVariable Long AnswerId) {
        ANSWER a = answerService.findById(AnswerId);
        return a;
    }

    @PostMapping("/Answers")
    public ANSWER createAnswer(@Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        QUESTION q = questionService.findById(Long.parseLong(parser.get("question_id").toString()));

        ANSWER a = new ANSWER();
        a.setAtext(parser.get("atext").toString());
        a.setQuestion(q);
        return answerService.save(a);
    }

    @PostMapping("/Answers/Batch")
    public List<ANSWER> createAnswers(@Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        QUESTION q = questionService.findById(Long.parseLong(parser.get("question_id").toString()));

        List<ANSWER> savedAns = new ArrayList<>();
        List<Object> answersStrings = factory.parseList(parser.get("answers").toString());
        for (Object o :
                answersStrings) {
            ANSWER a = new ANSWER();
            a.setAtext(o.toString());
            a.setQuestion(q);
            a.setQuestion_id(q.getId());
            a=answerService.save(a);
            savedAns.add(a);
        }

        return savedAns;
    }

    @PutMapping("/Answers/{AnswerId}")
    public ANSWER updateAnswer(@PathVariable Long AnswerId, @Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        ANSWER a = answerService.findById(AnswerId);

        if (parser.get("question_id") != null) {
            QUESTION q = questionService.findById(Long.parseLong(parser.get("question_id").toString()));
            a.setQuestion(q);
        }

        if (parser.get("atext") != null) {
            String atext = parser.get("atext").toString();
            a.setAtext(atext);
        }

        return answerService.save(a);
    }

    @DeleteMapping("/Answers/{AnswerId}")
    public String deleteAnswer(@PathVariable Long AnswerId) {
        return answerService.delete(AnswerId);
    }
}
