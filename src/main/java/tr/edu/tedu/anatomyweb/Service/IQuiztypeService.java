package tr.edu.tedu.anatomyweb.Service;

import tr.edu.tedu.anatomyweb.Model.QUIZTYPE;

import java.util.List;

public interface IQuiztypeService {

    public List<QUIZTYPE> findAll();
    public QUIZTYPE save(QUIZTYPE quiztype);
}
