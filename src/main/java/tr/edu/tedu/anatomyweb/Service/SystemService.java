package tr.edu.tedu.anatomyweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.SYSTEM;
import tr.edu.tedu.anatomyweb.Repository.SystemRepository;

import java.util.List;

@Service
public class SystemService implements ISystemService {

    @Autowired
    private SystemRepository repository;

    @Override
    public List<SYSTEM> findAll() {
        List<SYSTEM> systems = (List<SYSTEM>) repository.findAllByOrderByIDAsc();
        return systems;
    }

    @Override
    public SYSTEM save(SYSTEM system) {
        return repository.save(system);
    }

    @Override
    public SYSTEM findById(long systemId) {
        SYSTEM s = repository.findById(systemId)
                .orElseThrow(() -> new ResourceNotFoundException("System not found with id " + systemId));
        return s;
    }

    @Override
    public String delete(Long systemId) {
        try {
            repository.deleteById(systemId);
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