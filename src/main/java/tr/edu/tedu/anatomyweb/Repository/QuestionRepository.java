package tr.edu.tedu.anatomyweb.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tr.edu.tedu.anatomyweb.Model.QUESTION;
@Repository
public interface QuestionRepository extends CrudRepository<QUESTION, Long> {
}
