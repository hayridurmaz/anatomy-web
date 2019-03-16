package tr.edu.tedu.anatomyweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.STUDENT;
import tr.edu.tedu.anatomyweb.Repository.StudentRepository;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public List<STUDENT> findAll() {
        return repository.findAllByOrderByIDDesc();
    }


    @Override
    public STUDENT save(STUDENT s) {
        System.out.println(s.toString());
        return repository.save(s);
    }

    @Override
    public STUDENT findById(Long Id) {
        STUDENT t = repository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + Id));
        return t;
    }

    @Override
    public String delete(Long Id) {
        try {
            repository.deleteById(Id);
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
