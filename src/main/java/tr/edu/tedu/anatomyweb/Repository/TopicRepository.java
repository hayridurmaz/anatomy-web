package tr.edu.tedu.anatomyweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.edu.tedu.anatomyweb.Model.TOPIC;

public interface TopicRepository extends JpaRepository<TOPIC, Long> {
}
