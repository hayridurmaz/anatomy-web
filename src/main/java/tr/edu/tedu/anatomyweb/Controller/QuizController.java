package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Model.QUIZ;
import tr.edu.tedu.anatomyweb.Service.IQuizService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class QuizController {

    @Autowired
    IQuizService quizService;

    @GetMapping("/GetQuizzes")
    List<QUIZ> quizzes() {
        return quizService.findAll();
    }

    @PostMapping("/CreateQuiz")
    public QUIZ createQuiz(@Valid @RequestBody QUIZ quiz) {
        return quizService.save(quiz);
    }

   /* @PutMapping("/UpdateQuiz/{QuizId}")
    public QUIZ updateQuiz(@PathVariable Long QuizId, @Valid @RequestBody QUIZ quizRequest) {
        QUIZ q = quizService.findById(QuizId);
        q.setSYSTEMID(quizRequest.getSYSTEMID());
        q.setTYPE(quizRequest.getTYPE());
        return quizService.save(q);
    }
*/
    @DeleteMapping("/DeleteQuiz/{QuizId}")
    public ResponseEntity<?> deleteQuiz(@PathVariable Long QuizId) {
        quizService.delete(QuizId);
        return ResponseEntity.ok().build();
    }

}
