package tr.edu.tedu.anatomyweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.tedu.anatomyweb.Model.SYSTEM;

import java.util.List;

@Repository
public interface SystemRepository extends JpaRepository<SYSTEM, Long> {
    List<SYSTEM> findAllByOrderByIDDesc();
    List<SYSTEM> findAllByOrderByIDAsc();

}
