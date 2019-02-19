package tr.edu.tedu.anatomyweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.ANSWER;
import tr.edu.tedu.anatomyweb.Repository.AnswerRepository;

import java.util.List;

@Service
public class AnswerService implements IAnswerService {

    @Autowired
    AnswerRepository answerRepository;

    @Override
    public List<ANSWER> findAll() {
        return (List<ANSWER>) answerRepository.findAll();
    }

    @Override
    public ANSWER save(ANSWER answer) {
        return answerRepository.save(answer);
    }

    @Override
    public ANSWER findById(Long Id) {
        return answerRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + Id));
    }

    @Override
    public void delete(Long Id) {
        answerRepository.deleteById(Id);
    }
}
