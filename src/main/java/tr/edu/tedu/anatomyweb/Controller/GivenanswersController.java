package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Model.GIVENANSWERS;
import tr.edu.tedu.anatomyweb.Model.QUIZ;
import tr.edu.tedu.anatomyweb.Model.STUDENT;
import tr.edu.tedu.anatomyweb.Service.IGivenanswersService;
import tr.edu.tedu.anatomyweb.Service.IQuizService;
import tr.edu.tedu.anatomyweb.Service.IStudentService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class GivenanswersController {
    @Autowired
    IGivenanswersService givenanswersService;
    @Autowired
    IQuizService quizService;
    @Autowired
    IStudentService studentService;

   
    @GetMapping(("/Givenanswers"))
    List<GIVENANSWERS> getGivenAnswerswithParams(@RequestParam(value = "userid", required = false) Long userid, @RequestParam(value = "quizid", required = false) Long quizid) {
        if (userid != null && quizid != null) {
            STUDENT s = studentService.findById(userid);
            QUIZ q = quizService.findById(quizid);
            ArrayList<GIVENANSWERS> list = new ArrayList<>();
            list.add(givenanswersService.findByGivenanswers_quizAndGivenanswers_student(s, q));
            return list;
        } else if (userid != null && quizid == null) {
            STUDENT s = studentService.findById(userid);
            return givenanswersService.findAllByGivenanswers_student(s);
        } else if (userid == null && quizid != null) {
            QUIZ q = quizService.findById(quizid);
            return givenanswersService.findByGivenanswers_quiz(q);
        } else {
            return givenanswersService.findAll();
        }

    }


    @PostMapping("/Givenanswers")
    public GIVENANSWERS createGivenanswers(@Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        STUDENT s = (studentService.findById(Long.parseLong(parser.get("student_id").toString())));

        GIVENANSWERS givenanswers = new GIVENANSWERS();
        givenanswers.setGivenanswersquiz(quizService.findById(Long.parseLong(parser.get("quiz_id").toString())));
        givenanswers.setGivenanswersstudent(s);

        givenanswers.setJson(parser.get("json").toString());
        givenanswers.setGrade(Integer.parseInt(parser.get("grade").toString()));
        s.setScore(s.getScore() + Integer.parseInt(parser.get("grade").toString()));
        studentService.save(s);

        return givenanswersService.save(givenanswers);
    }

    @PutMapping("/Givenanswers")
    public GIVENANSWERS updateGivenanswers(@Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        STUDENT s = studentService.findById(Long.parseLong(parser.get("student_id").toString()));
        QUIZ q = quizService.findById(Long.parseLong(parser.get("quiz_id").toString()));

        GIVENANSWERS g = givenanswersService.findByGivenanswers_quizAndGivenanswers_student(s, q);

        g.setJson(parser.get("json").toString());

        if (parser.get("grade") != null) {
            g.setGrade(Integer.parseInt(parser.get("grade").toString()));
            s.setScore(s.getScore() + Integer.parseInt(parser.get("grade").toString()));
            studentService.save(s);
        }


        return givenanswersService.save(g);
    }

    @DeleteMapping("/Givenanswers")
    public String deleteGivenanswers(@Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        STUDENT s = studentService.findById(Long.parseLong(parser.get("student_id").toString()));
        QUIZ q = quizService.findById(Long.parseLong(parser.get("quiz_id").toString()));

        return givenanswersService.delete(s, q);
    }
}
