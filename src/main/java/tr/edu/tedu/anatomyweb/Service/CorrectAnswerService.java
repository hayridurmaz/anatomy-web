package tr.edu.tedu.anatomyweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.CORRECTANSWER;
import tr.edu.tedu.anatomyweb.Model.QUESTION;
import tr.edu.tedu.anatomyweb.Repository.CorrectAnswerRepository;

import java.util.List;

@Service
public class CorrectAnswerService implements ICorrectAnswerService {
    @Autowired
    private CorrectAnswerRepository repository;

    @Autowired
    private IQuestionService questionService;
    @Override
    public List<CORRECTANSWER> findAll() {
        List<CORRECTANSWER> correctanswers = repository.findAll();
        return correctanswers;
    }

    @Override
    public CORRECTANSWER save(CORRECTANSWER correctanswer) {
        return repository.save(correctanswer);
    }

    @Override
    public CORRECTANSWER findByQuestionId(Long questionId) {
        QUESTION q = questionService.findById(questionId);
        CORRECTANSWER c = repository.findByQuestion(q);
        return c;
    }
    @Override
    public CORRECTANSWER findById(Long id) {
        CORRECTANSWER c = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Correct answer not found with id " + id));
        return c;
    }


    @Override
    public String delete(Long corrId) {
        try {
            repository.deleteById(corrId);
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
