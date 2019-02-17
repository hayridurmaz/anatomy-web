package tr.edu.tedu.anatomyweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.tedu.anatomyweb.Model.QUIZ;
import tr.edu.tedu.anatomyweb.Model.QUIZTYPE;
import tr.edu.tedu.anatomyweb.Repository.QuizRepository;
import tr.edu.tedu.anatomyweb.Repository.QuizTypeRepository;

import java.util.List;
@Service
public class QuizService implements IQuizService {

    @Autowired
    private QuizRepository repository;

    @Override
    public List<QUIZ> findAll() {
        List<QUIZ> quizzes = (List<QUIZ>) repository.findAll();
        return quizzes;
    }
}
