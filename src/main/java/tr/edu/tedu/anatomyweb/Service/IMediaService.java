package tr.edu.tedu.anatomyweb.Service;

import org.springframework.data.repository.query.Param;
import tr.edu.tedu.anatomyweb.Model.MEDIA;
import tr.edu.tedu.anatomyweb.Model.SYSTEM;
import tr.edu.tedu.anatomyweb.Model.TOPIC;
import tr.edu.tedu.anatomyweb.Utils.MediaType;

import java.util.List;

public interface IMediaService {
    List<MEDIA> findAll();

    MEDIA save(MEDIA MEDIA);

    MEDIA findById(Long Id);

    String delete(Long Id);

    List<MEDIA> findBySystemId(Long systemid);

    //List<MEDIA> findBySystemAndAndMediaType(SYSTEM s, MediaType m);

    List<MEDIA> findAllByTopics(TOPIC topıc);

    List<MEDIA> findBySystemIdAndMediaType(Long systemid, MediaType mediatype);
}
