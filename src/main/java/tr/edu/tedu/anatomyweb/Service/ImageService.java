package tr.edu.tedu.anatomyweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.IMAGE;
import tr.edu.tedu.anatomyweb.Repository.ImageRepository;

import java.util.List;

@Service
public class ImageService implements IImageService {
    @Autowired
    ImageRepository imageRepository;


    @Override
    public List<IMAGE> findAll() {
        return (List<IMAGE>) imageRepository.findAll();
    }

    @Override
    public IMAGE save(IMAGE image) {
        return imageRepository.save(image);
    }

    @Override
    public IMAGE findById(Long Id) {
        return imageRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Image not found with id " + Id));
    }

    @Override
    public void delete(Long Id) {
        imageRepository.deleteById(Id);
    }
}
