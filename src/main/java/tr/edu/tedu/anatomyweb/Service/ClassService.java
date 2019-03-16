package tr.edu.tedu.anatomyweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.CLASS;
import tr.edu.tedu.anatomyweb.Repository.ClassRepository;

import java.util.List;

@Service
public class ClassService implements IClassService {

    @Autowired
    ClassRepository classRepository;

    @Override
    public List<CLASS> findAll() {
        return classRepository.findAll();
    }

    @Override
    public CLASS save(CLASS class_) {
        return classRepository.save(class_);
    }

    @Override
    public CLASS findById(Long Id) {
        return classRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Class not found with id " + Id));
    }

    @Override
    public String delete(Long Id) {
        try {
            classRepository.deleteById(Id);
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
