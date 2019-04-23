package tr.edu.tedu.anatomyweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.tedu.anatomyweb.Model.CORRECTANSWER;
import tr.edu.tedu.anatomyweb.Model.QUESTION;

@Repository
public interface CorrectAnswerRepository extends JpaRepository<CORRECTANSWER, Long> {
    CORRECTANSWER findByQuestion(QUESTION questıon);
}
