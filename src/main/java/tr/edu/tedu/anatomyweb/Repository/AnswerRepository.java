package tr.edu.tedu.anatomyweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.tedu.anatomyweb.Model.ANSWER;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<ANSWER, Long> {
    List<ANSWER> findAllByOrderByIdAsc();
}
