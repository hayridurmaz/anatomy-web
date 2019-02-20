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
}
