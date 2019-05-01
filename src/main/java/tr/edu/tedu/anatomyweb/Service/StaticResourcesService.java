package tr.edu.tedu.anatomyweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.STATICRESOURCES;
import tr.edu.tedu.anatomyweb.Repository.StaticResourcesRepository;

import java.util.List;

@Service
public class StaticResourcesService implements IStaticResourcesService{

    @Autowired
    StaticResourcesRepository StaticResourcesRepository;
    @Override
    public List<STATICRESOURCES> findAll(){
        List<STATICRESOURCES> resources = StaticResourcesRepository.findAll();
        return resources;
    }
    @Override
    public STATICRESOURCES save(STATICRESOURCES resources){
        return StaticResourcesRepository.save(resources);
    }
    @Override
    public STATICRESOURCES findById(Long resourcesID){
        STATICRESOURCES resource = StaticResourcesRepository.findById(resourcesID).orElseThrow(() -> new ResourceNotFoundException("Given resource not found with id " + resourcesID));;
        return resource;
    }
    @Override
    public String delete(Long resourcesID){
        try {
            StaticResourcesRepository.deleteById(resourcesID);
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
