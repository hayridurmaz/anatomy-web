package tr.edu.tedu.anatomyweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tr.edu.tedu.anatomyweb.Model.*;
import tr.edu.tedu.anatomyweb.Utils.MediaType;

import java.util.List;

@Repository
public interface StaticResourcesRepository extends JpaRepository<STATICRESOURCES, Long> {



    List<STATICRESOURCES> findBySystem_idAndResource_type(SYSTEM system, STATICRESOURCETYPES type);

}
