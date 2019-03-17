package tr.edu.tedu.anatomyweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.GIVENANSWERS;
import tr.edu.tedu.anatomyweb.Repository.GivenanswersRepository;

import java.util.List;

@Service
public class GivenanswersService implements IGivenanswersService {
    @Autowired
    private GivenanswersRepository repository;

    @Override
    public List<GIVENANSWERS> findAll() {
        List<GIVENANSWERS> givenAnswers = repository.findAll();
        return givenAnswers;
    }

    @Override
    public GIVENANSWERS save(GIVENANSWERS gıvenanswers) {
        return repository.save(gıvenanswers);
    }

    @Override
    public GIVENANSWERS findById(Long corrId) {
        GIVENANSWERS c = repository.findById(corrId)
                .orElseThrow(() -> new ResourceNotFoundException("Given answer tuple not found with id " + corrId));
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
