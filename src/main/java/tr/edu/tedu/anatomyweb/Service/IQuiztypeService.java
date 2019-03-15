package tr.edu.tedu.anatomyweb.Service;

import tr.edu.tedu.anatomyweb.Model.QUIZTYPE;

import java.util.List;

public interface IQuiztypeService {

    List<QUIZTYPE> findAll();

    QUIZTYPE save(QUIZTYPE quiztype);

    QUIZTYPE findById(Long quiztypeId);

    String delete(Long quiztypeId);
}
