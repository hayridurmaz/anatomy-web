package tr.edu.tedu.anatomyweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tr.edu.tedu.anatomyweb.Model.MEDIA;
import tr.edu.tedu.anatomyweb.Model.SYSTEM;
import tr.edu.tedu.anatomyweb.Utils.MediaType;

import java.util.List;

@Repository
public interface MediaRepository extends JpaRepository<MEDIA, Long> {

    @Query("SELECT M FROM MEDIA M WHERE M.system_id = :systemid")
    List<MEDIA> findBySystemId(@Param("systemid") Long systemid);

  //  List<MEDIA> findBySystemAndMedia_type(SYSTEM system, MediaType media_type);

    @Query("SELECT M FROM MEDIA M WHERE M.system_id = :systemid AND M.media_type = :mediatype")
    List<MEDIA> findBySystemIdAndMediaType(@Param("systemid") Long systemid, @Param("mediatype") MediaType mediatype);
}
