package tr.edu.tedu.anatomyweb.Service;

import tr.edu.tedu.anatomyweb.Model.TEACHER;

import java.util.List;

public interface ITeacherService {
    public List<TEACHER> findAll();

    public TEACHER save(TEACHER teacher);

    public TEACHER findById(long id);

    public String delete(Long id);

}
