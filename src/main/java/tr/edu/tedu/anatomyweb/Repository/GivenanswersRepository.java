package tr.edu.tedu.anatomyweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.tedu.anatomyweb.Model.GIVENANSWERS;
import tr.edu.tedu.anatomyweb.Model.QUIZ;
import tr.edu.tedu.anatomyweb.Model.STUDENT;

import java.util.List;

@Repository
public interface GivenanswersRepository extends JpaRepository<GIVENANSWERS, Long> {

    List<GIVENANSWERS> findAllByGivenanswersstudent(STUDENT student);

    GIVENANSWERS findByGivenanswersquizAndGivenanswersstudent(QUIZ quız,STUDENT student);

    List<GIVENANSWERS> findAllByGivenanswersquiz(QUIZ quız);

}
