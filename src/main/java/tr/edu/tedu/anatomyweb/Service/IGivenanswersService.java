package tr.edu.tedu.anatomyweb.Service;


import tr.edu.tedu.anatomyweb.Model.GIVENANSWERS;

import java.util.List;

public interface IGivenanswersService {

    List<GIVENANSWERS> findAll();

    GIVENANSWERS save(GIVENANSWERS gıvenanswers);

    GIVENANSWERS findById(Long Id);

    String delete(Long Id);
}

