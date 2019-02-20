package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Model.IMAGE;
import tr.edu.tedu.anatomyweb.Model.QUESTION;
import tr.edu.tedu.anatomyweb.Model.QUIZ;
import tr.edu.tedu.anatomyweb.Model.TOPIC;
import tr.edu.tedu.anatomyweb.Service.IImageService;
import tr.edu.tedu.anatomyweb.Service.IQuestionService;
import tr.edu.tedu.anatomyweb.Service.IQuizService;
import tr.edu.tedu.anatomyweb.Service.ITopicService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class QuestionController {

    @Autowired
    IImageService imageService;
    @Autowired
    ITopicService topicService;
    @Autowired
    IQuizService quizService;
    @Autowired
    IQuestionService questionService;

    @GetMapping("/Questions")
    List<QUESTION> getQuestions() {
        return questionService.findAll();
    }

    @GetMapping(("/Questions/{QuestionId}"))
    QUESTION getQuestionById(@PathVariable Long QuestionId) {
        QUESTION q = questionService.findById(QuestionId);
        return q;
    }

    @PostMapping("/Questions")
    public QUESTION createQuestion(@Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        IMAGE i = imageService.findById(Long.parseLong(parser.get("image_id").toString()));
        TOPIC t = topicService.findById(Long.parseLong(parser.get("topic_id").toString()));
        QUIZ q = quizService.findById(Long.parseLong(parser.get("quiz_id").toString()));
        String qtext = parser.get("qtext").toString();
        String hint = parser.get("hint").toString();

        QUESTION qu = new QUESTION();
        qu.setHint(hint);
        qu.setQtext(qtext);
        qu.setImage(i);
        qu.setTopic(t);
        qu.setQuiz(q);
        return questionService.save(qu);
    }

    @PutMapping("/Questions/{QuestionId}")
    public QUESTION updateQuestion(@PathVariable Long QuestionId, @Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        QUESTION qu = questionService.findById(QuestionId);

        IMAGE i;
        TOPIC t;
        QUIZ q;
        String qtext;
        String hint;

        if (parser.get("image_id") != null) {
            i = imageService.findById(Long.parseLong(parser.get("image_id").toString()));
            qu.setImage(i);
        }

        if (parser.get("topic_id") != null) {
            t = topicService.findById(Long.parseLong(parser.get("topic_id").toString()));
            qu.setTopic(t);
        }

        if (parser.get("quiz_id") != null) {
            q = quizService.findById(Long.parseLong(parser.get("quiz_id").toString()));
            qu.setQuiz(q);
        }

        if (parser.get("qtext") != null) {
            qtext = parser.get("qtext").toString();
            qu.setQtext(qtext);
        }

        if (parser.get("hint") != null) {
            hint = parser.get("hint").toString();
            qu.setHint(hint);
        }
        return questionService.save(qu);
    }

    @DeleteMapping("/Questions/{QuestionId}")
    public String deleteQuestion(@PathVariable Long QuestionId) {
        return questionService.delete(QuestionId);
    }
}
