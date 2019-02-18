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
        List<SYSTEM> systems = (List<SYSTEM>) repository.findAll();
        return systems;
    }

    @Override
    public SYSTEM save(SYSTEM system) {
        return repository.save(system);
    }

    @Override
    public SYSTEM findById(long systemId) {
        SYSTEM s = repository.findById(systemId).orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + systemId));
        return s;
    }

    @Override
    public void delete(Long systemId) {
        SYSTEM s = findById(systemId);
        repository.delete(s);
    }

}