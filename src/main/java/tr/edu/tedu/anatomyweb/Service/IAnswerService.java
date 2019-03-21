package tr.edu.tedu.anatomyweb.Service;

import tr.edu.tedu.anatomyweb.Model.ANSWER;

import java.util.List;

public interface IAnswerService {
    List<ANSWER> findAll();

    ANSWER save(ANSWER answer);

    ANSWER findById(Long Id);

    String delete(Long Id);
}
