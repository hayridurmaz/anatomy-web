package tr.edu.tedu.anatomyweb.Service;

import tr.edu.tedu.anatomyweb.Model.QUIZ;

import java.util.List;

public interface IQuizService {
    public List<QUIZ> findAll();
    public QUIZ save(QUIZ quiz);
    public QUIZ findById(Long Id);
    public void delete(Long Id);
}
