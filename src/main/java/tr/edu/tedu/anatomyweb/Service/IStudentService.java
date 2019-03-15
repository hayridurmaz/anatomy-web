package tr.edu.tedu.anatomyweb.Service;


import tr.edu.tedu.anatomyweb.Model.STUDENT;

import java.util.List;

public interface IStudentService {
    List<STUDENT> findAll();
    
    STUDENT save(STUDENT student);

    STUDENT findById(Long Id);

    String delete(Long Id);
}
