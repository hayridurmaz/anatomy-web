package tr.edu.tedu.anatomyweb.Service;

import tr.edu.tedu.anatomyweb.Model.CORRECTANSWER;

import java.util.List;

public interface ICorrectAnswerService {

    List<CORRECTANSWER> findAll();

    CORRECTANSWER save(CORRECTANSWER correctanswer);

    CORRECTANSWER findByQuestionId(Long questionId);
    CORRECTANSWER findById(Long Id);

    String delete(Long Id);
}
