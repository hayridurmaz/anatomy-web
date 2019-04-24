package tr.edu.tedu.anatomyweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.tedu.anatomyweb.Model.QUIZ;
import tr.edu.tedu.anatomyweb.Model.SYSTEM;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<QUIZ, Long> {

    List<QUIZ> findAllBySystem(SYSTEM system);
}
