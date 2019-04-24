package tr.edu.tedu.anatomyweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.CORRECTANSWER;
import tr.edu.tedu.anatomyweb.Model.QUESTION;
import tr.edu.tedu.anatomyweb.Model.QUIZ;
import tr.edu.tedu.anatomyweb.Model.SYSTEM;
import tr.edu.tedu.anatomyweb.Repository.QuizRepository;

import java.util.List;

@Service
public class QuizService implements IQuizService {

    @Autowired
    private QuizRepository repository;

    @Autowired
    private ICorrectAnswerService correctAnswerService;

    @Autowired
    private IQuestionService questionService;

    @Autowired
    private IAnswerService answerService;

    @Override
    public List<QUIZ> findAll() {
        List<QUIZ> quizzes = repository.findAll();
        return quizzes;
    }

    @Override
    public QUIZ save(QUIZ quiz) {
        return repository.save(quiz);
    }

    @Override
    public QUIZ findById(Long quizId) {
        QUIZ q = repository.findById(quizId)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + quizId));
        return q;
    }

    @Override
    public String delete(Long quizId) {
        try {
            QUIZ q = findById(quizId);
            System.out.println(q.toString());

            if(q.getQuiz_clases().size()!=0){
                return "Quiz belongs to some classes: "+q.getQuiz_clases().size()+" classes";
            }

            if(q.getQuizgivenanswers().size()!=0){
                return "This quiz is given some answers, cannot delete: "+q.getQuizgivenanswers().size()+" students";
            }
            for (QUESTION question:q.questions
                 ) {
                CORRECTANSWER correctanswer = correctAnswerService.findByQuestionId(question.getId());
                answerService.delete(correctanswer.getAnswer().getId());
                questionService.delete(correctanswer.getQuestion().getId());
                correctAnswerService.delete(correctanswer.getId());
            }

            repository.deleteById(quizId);
            return "Deleted";
        } catch (Exception e) {
            Throwable t = e;
            while (t.getCause() != null) {
                t = t.getCause();
            }

            return "Cannot delete: " + t.getMessage();
        }
    }

    @Override
    public List<QUIZ> findAllBySystem(SYSTEM system) {
        return repository.findAllBySystem(system);
    }
}
