package tr.edu.tedu.anatomyweb.Service;

import tr.edu.tedu.anatomyweb.Model.QUESTION;

import java.util.List;

public interface IQuestionService {

    List<QUESTION> findAll();

    QUESTION save(QUESTION question);

    QUESTION findById(Long Id);

    String delete(Long Id);
}
