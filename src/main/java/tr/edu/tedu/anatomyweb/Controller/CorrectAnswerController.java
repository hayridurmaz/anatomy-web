package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Model.CORRECTANSWER;
import tr.edu.tedu.anatomyweb.Model.QUESTION;
import tr.edu.tedu.anatomyweb.Service.IAnswerService;
import tr.edu.tedu.anatomyweb.Service.ICorrectAnswerService;
import tr.edu.tedu.anatomyweb.Service.IQuestionService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class CorrectAnswerController {
    @Autowired
    ICorrectAnswerService correctAnswerService;
    @Autowired
    IQuestionService questionService;
    @Autowired
    IAnswerService answerService;

    @GetMapping("/CorrectAnswers")
    List<CORRECTANSWER> getCorrectAnswers() {
        return correctAnswerService.findAll();
    }

    @GetMapping(("/CorrectAnswers/{qId}"))
    CORRECTANSWER getCorrectAnswerByQuestionId(@PathVariable Long qId) {
        CORRECTANSWER a = correctAnswerService.findByQuestionId(qId);
        return a;
    }

    @PostMapping("/CorrectAnswers")
    public CORRECTANSWER createCorrectAnswer(@Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        CORRECTANSWER correctanswer = new CORRECTANSWER();
        correctanswer.setAnswer(answerService.findById(Long.parseLong(parser.get("answer_id").toString())));
        correctanswer.setQuestion((questionService.findById(Long.parseLong(parser.get("question_id").toString()))));

        QUESTION q = questionService.findById(Long.parseLong(parser.get("question_id").toString()));
        if (!q.getAnswers().contains(answerService.findById(Long.parseLong(parser.get("answer_id").toString())))) {
            return null;
        }

        return correctAnswerService.save(correctanswer);
    }

    @PutMapping("/CorrectAnswers/{corrId}")
    public CORRECTANSWER updateCorrectAnswer(@PathVariable Long corrId, @Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        CORRECTANSWER correctanswer = correctAnswerService.findById(corrId);

        if (parser.get("answer_id") != null) {
            correctanswer.setAnswer(answerService.findById(Long.parseLong(parser.get("answer_id").toString())));
        }
        if (parser.get("question_id") != null) {
            correctanswer.setQuestion((questionService.findById(Long.parseLong(parser.get("question_id").toString()))));
        }

        return correctAnswerService.save(correctanswer);
    }

    @DeleteMapping("/CorrectAnswers/{corrId}")
    public String deleteCorrectAnswer(@PathVariable Long corrId) {
        return correctAnswerService.delete(corrId);
    }
}
