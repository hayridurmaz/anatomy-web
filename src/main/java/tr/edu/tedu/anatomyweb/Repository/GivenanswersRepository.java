package tr.edu.tedu.anatomyweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.tedu.anatomyweb.Model.GIVENANSWERS;

@Repository
public interface GivenanswersRepository extends JpaRepository<GIVENANSWERS, Long> {
}
