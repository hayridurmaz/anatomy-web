package tr.edu.tedu.anatomyweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.edu.tedu.anatomyweb.Model.IMAGE;

public interface ImageRepository extends JpaRepository<IMAGE, Long> {
}
