package tr.edu.tedu.anatomyweb.Service;

import org.springframework.data.repository.query.Param;
import tr.edu.tedu.anatomyweb.Model.MEDIA;

import java.util.List;

public interface IMediaService {
    public List<MEDIA> findAll();

    public MEDIA save(MEDIA MEDIA);

    public MEDIA findById(Long Id);

    public String delete(Long Id);

    public List<MEDIA> findBySystemId(Long systemid);
}
