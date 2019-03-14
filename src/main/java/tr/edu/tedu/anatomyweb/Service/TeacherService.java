package tr.edu.tedu.anatomyweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.TEACHER;
import tr.edu.tedu.anatomyweb.Repository.TeacherRepository;

import java.util.List;

public class TeacherService implements ITeacherService {

    @Autowired
    private TeacherRepository repository;

    @Override
    public List<TEACHER> findAll() {
        return repository.findAllByOrderByIDAsc();
    }

    @Override
    public TEACHER save(TEACHER teacher) {
        return repository.save(teacher);
    }

    @Override
    public TEACHER findById(long id) {
        TEACHER t = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id " + id));
        return t;
    }

    @Override
    public String delete(Long id) {
        try {
            repository.deleteById(id);
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
