package tr.edu.tedu.anatomyweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.CORRECTANSWER;
import tr.edu.tedu.anatomyweb.Repository.CorrectAnswerRepository;

import java.util.List;

@Service
public class CorrectAnswerService implements ICorrectAnswerService {
    @Autowired
    private CorrectAnswerRepository repository;

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
    public CORRECTANSWER findById(Long corrId) {
        CORRECTANSWER c = repository.findById(corrId)
                .orElseThrow(() -> new ResourceNotFoundException("Correct answer tuple not found with id " + corrId));
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
