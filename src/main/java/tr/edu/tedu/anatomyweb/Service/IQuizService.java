package tr.edu.tedu.anatomyweb.Service;

import tr.edu.tedu.anatomyweb.Model.QUIZ;

import java.util.List;

public interface IQuizService {

    List<QUIZ> findAll();

    QUIZ save(QUIZ quiz);

    QUIZ findById(Long Id);

    String delete(Long Id);
}
