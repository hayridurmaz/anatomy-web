package tr.edu.tedu.anatomyweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.tedu.anatomyweb.Model.QUIZTYPE;

import java.util.List;

@Repository
public interface QuizTypeRepository extends JpaRepository<QUIZTYPE, Long> {
    List<QUIZTYPE> findAllByOrderByIDAsc();
}
