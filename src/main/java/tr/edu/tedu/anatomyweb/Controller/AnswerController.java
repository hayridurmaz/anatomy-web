package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Model.*;
import tr.edu.tedu.anatomyweb.Service.IAnswerService;
import tr.edu.tedu.anatomyweb.Service.IQuestionService;

import javax.validation.Valid;
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

    @PutMapping("/Answers/{AnswerId}")
    public ANSWER updateAnswer(@PathVariable Long AnswerId, @Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        ANSWER a = answerService.findById(AnswerId);
        QUESTION q;
        String atext;

        if (parser.get("question_id") != null) {
            q = questionService.findById(Long.parseLong(parser.get("question_id").toString()));
        } else {
            q = a.getQuestion();// is it really needed?
        }

        if (parser.get("atext") != null) {
            atext = parser.get("atext").toString();
        } else {
            atext = a.getAtext();
        }

        a.setQuestion(q);
        a.setAtext(atext);
        return answerService.save(a);
    }

    @DeleteMapping("/Answers/{AnswerId}")
    public ResponseEntity<?> deleteAnswer(@PathVariable Long AnswerId) {
        answerService.delete(AnswerId);
        return ResponseEntity.ok().build();
    }
}
