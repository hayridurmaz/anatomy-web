package tr.edu.tedu.anatomyweb.Service;


import tr.edu.tedu.anatomyweb.Model.STUDENT;

import java.util.List;

public interface IStudentService {
    public List<STUDENT> findAll();

    public STUDENT save(STUDENT student);

    public STUDENT findById(Long Id);

    public String delete(Long Id);
}
