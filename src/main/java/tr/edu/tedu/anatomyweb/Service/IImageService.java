package tr.edu.tedu.anatomyweb.Service;

import tr.edu.tedu.anatomyweb.Model.IMAGE;

import java.util.List;

public interface IImageService {
    public List<IMAGE> findAll();

    public IMAGE save(IMAGE image);

    public IMAGE findById(Long Id);

    public String delete(Long Id);
}
