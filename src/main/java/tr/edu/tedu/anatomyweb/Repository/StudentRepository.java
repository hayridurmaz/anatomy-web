package tr.edu.tedu.anatomyweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.tedu.anatomyweb.Model.CLASS;
import tr.edu.tedu.anatomyweb.Model.STUDENT;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<STUDENT, Long> {
    List<STUDENT> findAllByOrderByIDDesc();

    List<STUDENT> findAllByStudent_classOrderByID(CLASS student_class);
}
