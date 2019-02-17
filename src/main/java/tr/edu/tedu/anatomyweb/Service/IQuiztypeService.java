package tr.edu.tedu.anatomyweb.Service;

import tr.edu.tedu.anatomyweb.Model.QUIZTYPE;

import java.util.List;
import java.util.Optional;

public interface IQuiztypeService {

    public List<QUIZTYPE> findAll();
    public QUIZTYPE save(QUIZTYPE quiztype);
    public Optional<QUIZTYPE> findById(long quiztypeId);
    public void delete(QUIZTYPE quiztype);
}
