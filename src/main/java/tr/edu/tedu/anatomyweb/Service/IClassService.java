package tr.edu.tedu.anatomyweb.Service;

import tr.edu.tedu.anatomyweb.Model.CLASS;
import tr.edu.tedu.anatomyweb.Model.TEACHER;

import java.util.List;

public interface IClassService {

    List<CLASS> findAll();

    CLASS save(CLASS class_);

    CLASS findById(Long Id);

    String delete(Long Id);

    List<CLASS> findAllByTeachers(TEACHER teacher);
}
