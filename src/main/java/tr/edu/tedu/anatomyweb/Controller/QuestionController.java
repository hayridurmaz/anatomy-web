package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Model.*;
import tr.edu.tedu.anatomyweb.Service.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class QuestionController {

    @Autowired
    IMediaService mediaService;
    @Autowired
    ITopicService topicService;
    @Autowired
    IQuizService quizService;
    @Autowired
    IQuestionService questionService;
    @Autowired
    IAnswerService answerService;

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

        MEDIA i = mediaService.findById(Long.parseLong(parser.get("media_id").toString()));
        TOPIC t = topicService.findById(Long.parseLong(parser.get("topic_id").toString()));
        QUIZ q = quizService.findById(Long.parseLong(parser.get("quiz_id").toString()));
        String qtext = parser.get("qtext").toString();
        String hint = parser.get("hint").toString();

        QUESTION qu = new QUESTION();
        qu.setHint(hint);
        qu.setQtext(qtext);
        qu.setMEDIA(i);
        qu.setTopic(t);
        qu.setQuiz(q);
        return questionService.save(qu);
    }

    @PutMapping("/Questions/{QuestionId}")
    public QUESTION updateQuestion(@PathVariable Long QuestionId, @Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        QUESTION qu = questionService.findById(QuestionId);

        MEDIA i;
        TOPIC t;
        QUIZ q;
        String qtext;
        String hint;

        if (parser.get("media_id") != null) {
            i = mediaService.findById(Long.parseLong(parser.get("media_id").toString()));
            qu.setMEDIA(i);
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
