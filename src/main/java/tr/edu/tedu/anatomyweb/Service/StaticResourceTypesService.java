package tr.edu.tedu.anatomyweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.STATICRESOURCETYPES;
import tr.edu.tedu.anatomyweb.Repository.StaticResourceTypesRepository;

import java.util.List;
@Service
public class StaticResourceTypesService implements IStaticResourceTypesService {

    @Autowired
    private StaticResourceTypesRepository repository;

    @Override
    public List<STATICRESOURCETYPES> findAll(){
        List<STATICRESOURCETYPES> all = repository.findAll();
        return all;
    }

    @Override
    public STATICRESOURCETYPES save(STATICRESOURCETYPES srt){
        return repository.save(srt);
    }

    public STATICRESOURCETYPES findById(Long resourceTypeId){
        STATICRESOURCETYPES type = repository.findById(resourceTypeId).orElseThrow(() -> new ResourceNotFoundException("Given resource type not found with id " + resourceTypeId));;
        return type;
    }

    public String delete(Long resourceTypeId){
        try {
            repository.deleteById(resourceTypeId);
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
