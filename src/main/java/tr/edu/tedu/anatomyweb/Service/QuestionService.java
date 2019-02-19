package tr.edu.tedu.anatomyweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.QUESTION;
import tr.edu.tedu.anatomyweb.Model.QUIZ;
import tr.edu.tedu.anatomyweb.Repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionService implements IQuestionService{

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public List<QUESTION> findAll(){
        List<QUESTION> questions = (List<QUESTION>) questionRepository.findAll();
        return questions;
    }

    @Override
    public QUESTION save(QUESTION question){
        return questionRepository.save(question);
    }
    @Override
    public QUESTION findById(Long Id){
        QUESTION q = questionRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + Id));
        return q;
    }

    @Override
    public void delete(Long Id){
        questionRepository.deleteById(Id);
    }
}
