package tr.edu.tedu.anatomyweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.tedu.anatomyweb.Model.TEACHER;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<TEACHER, Long> {
    public List<TEACHER> findAllByOrderByIDDesc();
}
