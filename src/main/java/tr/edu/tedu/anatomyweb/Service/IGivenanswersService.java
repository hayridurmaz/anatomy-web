package tr.edu.tedu.anatomyweb.Service;


import tr.edu.tedu.anatomyweb.Model.GIVENANSWERS;
import tr.edu.tedu.anatomyweb.Model.QUIZ;
import tr.edu.tedu.anatomyweb.Model.STUDENT;

import java.util.List;

public interface IGivenanswersService {

    List<GIVENANSWERS> findAll();

    GIVENANSWERS save(GIVENANSWERS gıvenanswers);

    GIVENANSWERS findById(Long Id);

    String delete(STUDENT s, QUIZ q);

    List<GIVENANSWERS> findAllByGivenanswers_student(STUDENT student);

    GIVENANSWERS findByGivenanswers_quizAndGivenanswers_student(STUDENT student, QUIZ quız);

}

