package tr.edu.tedu.anatomyweb.Repository;

import org.springframework.data.repository.CrudRepository;
import tr.edu.tedu.anatomyweb.Model.SYSTEM;
import tr.edu.tedu.anatomyweb.Model.TOPIC;

public interface TopicRepository extends CrudRepository<TOPIC, Long> {
}
