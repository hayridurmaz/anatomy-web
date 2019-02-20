package tr.edu.tedu.anatomyweb.Service;

import tr.edu.tedu.anatomyweb.Model.QUESTION;

import java.util.List;

public interface IQuestionService {

    public List<QUESTION> findAll();

    public QUESTION save(QUESTION question);

    public QUESTION findById(Long Id);

    public String delete(Long Id);
}
