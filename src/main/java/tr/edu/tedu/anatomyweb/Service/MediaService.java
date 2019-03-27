package tr.edu.tedu.anatomyweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.MEDIA;
import tr.edu.tedu.anatomyweb.Repository.MediaRepository;

import java.util.List;

@Service
public class MediaService implements IMediaService {
    @Autowired
    MediaRepository mediaRepository;

    @Override
    public List<MEDIA> findAll() {
        return mediaRepository.findAll();
    }

    @Override
    public MEDIA save(MEDIA MEDIA) {
        return mediaRepository.save(MEDIA);
    }

    @Override
    public MEDIA findById(Long Id) {
        return mediaRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Media not found with id " + Id));
    }

    @Override
    public List<MEDIA> findBySystemId(Long Id) {
        return mediaRepository.findBySystemId(Id);
    }

    @Override
    public String delete(Long Id) {
        try {
            mediaRepository.deleteById(Id);
            return "Deleted";
        } catch (Exception e) {
            Throwable t = e;
            while (t.getCause() != null) {
                t = t.getCause();
            }

            return "Cannot delete: " + t.getMessage();
        }
    }
}
