package tr.edu.tedu.anatomyweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.edu.tedu.anatomyweb.Model.STATICRESOURCES;
import tr.edu.tedu.anatomyweb.Model.STATICRESOURCETYPES;
@Repository
public interface StaticResourcesRepository extends JpaRepository<STATICRESOURCES, Long> {
}
