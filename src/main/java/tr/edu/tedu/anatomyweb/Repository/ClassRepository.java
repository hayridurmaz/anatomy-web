package tr.edu.tedu.anatomyweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.tedu.anatomyweb.Model.CLASS;
import tr.edu.tedu.anatomyweb.Model.TEACHER;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface ClassRepository extends JpaRepository<CLASS, Long> {

    List<CLASS> findAllByTeachers(TEACHER teacher);
}
