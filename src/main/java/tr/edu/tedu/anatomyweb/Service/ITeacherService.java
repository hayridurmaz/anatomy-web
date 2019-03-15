package tr.edu.tedu.anatomyweb.Service;

import tr.edu.tedu.anatomyweb.Model.TEACHER;

import java.util.List;

public interface ITeacherService {
    List<TEACHER> findAll();

    TEACHER save(TEACHER teacher);

    TEACHER findById(long id);

    String delete(Long id);

}
