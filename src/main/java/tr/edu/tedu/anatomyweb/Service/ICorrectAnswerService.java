package tr.edu.tedu.anatomyweb.Service;

import tr.edu.tedu.anatomyweb.Model.CORRECTANSWER;

import java.util.List;

public interface ICorrectAnswerService {

    public List<CORRECTANSWER> findAll();

    public CORRECTANSWER save(CORRECTANSWER correctanswer);

    public CORRECTANSWER findById(Long Id);

    public String delete(Long Id);
}
