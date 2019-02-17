package tr.edu.tedu.anatomyweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.QUIZ;
import tr.edu.tedu.anatomyweb.Repository.QuizRepository;

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

    @Override
    public QUIZ save(QUIZ quiz){
        return repository.save(quiz);
    }

    @Override
    public QUIZ findById(Long Id){
        QUIZ q = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + Id));
        return q;
    }

    @Override
    public void delete(Long Id){
        QUIZ q = findById(Id);
        repository.delete(q);
    }
}
