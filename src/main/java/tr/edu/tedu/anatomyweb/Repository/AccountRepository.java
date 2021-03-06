package tr.edu.tedu.anatomyweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.tedu.anatomyweb.Model.ACCOUNT;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<ACCOUNT, Long> {
    ACCOUNT findByUsername(String Username);

    List<ACCOUNT> findAllByOrderByIDAsc();
}
