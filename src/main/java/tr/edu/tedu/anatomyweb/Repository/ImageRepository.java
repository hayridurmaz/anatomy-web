package tr.edu.tedu.anatomyweb.Repository;

import org.springframework.data.repository.CrudRepository;
import tr.edu.tedu.anatomyweb.Model.IMAGE;

public interface ImageRepository extends CrudRepository<IMAGE, Long> {
}
