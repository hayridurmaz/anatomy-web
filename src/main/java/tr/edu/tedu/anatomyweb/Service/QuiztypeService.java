package tr.edu.tedu.anatomyweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.QUIZTYPE;
import tr.edu.tedu.anatomyweb.Repository.QuizTypeRepository;

import java.util.List;

@Service
public class QuiztypeService implements IQuiztypeService {

    @Autowired
    private QuizTypeRepository repository;

    @Override
    public List<QUIZTYPE> findAll() {
        List<QUIZTYPE> quiztypes = (List<QUIZTYPE>) repository.findAll();
        return quiztypes;
    }

    @Override
    public QUIZTYPE save(QUIZTYPE quiztype) {
        return repository.save(quiztype);
    }

    @Override
    public QUIZTYPE findById(Long quiztypeId) {
        QUIZTYPE q = repository.findById(quiztypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz type not found with id " + quiztypeId));
        return q;
    }

    @Override
    public void delete(Long quiztypeId) {
        repository.deleteById(quiztypeId);
    }

}
