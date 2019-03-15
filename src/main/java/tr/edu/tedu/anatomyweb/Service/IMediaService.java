package tr.edu.tedu.anatomyweb.Service;

import tr.edu.tedu.anatomyweb.Model.MEDIA;

import java.util.List;

public interface IMediaService {
    List<MEDIA> findAll();

    MEDIA save(MEDIA MEDIA);

    MEDIA findById(Long Id);

    String delete(Long Id);
}
