package tr.edu.tedu.anatomyweb.Service;

import tr.edu.tedu.anatomyweb.Model.ANSWER;

import java.util.List;

public interface IAnswerService {
    public List<ANSWER> findAll();
    public ANSWER save(ANSWER answer);
    public ANSWER findById(Long Id);
    public void delete(Long Id);
}
