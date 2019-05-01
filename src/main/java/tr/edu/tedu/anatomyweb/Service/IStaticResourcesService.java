package tr.edu.tedu.anatomyweb.Service;

import tr.edu.tedu.anatomyweb.Model.QUIZTYPE;
import tr.edu.tedu.anatomyweb.Model.STATICRESOURCES;
import tr.edu.tedu.anatomyweb.Model.STATICRESOURCETYPES;
import tr.edu.tedu.anatomyweb.Model.SYSTEM;

import java.util.List;

public interface IStaticResourcesService {


    List<STATICRESOURCES> findAll();

    STATICRESOURCES save(STATICRESOURCES resources);

    STATICRESOURCES findById(Long resourcesID);

    String delete(Long resourcesID);

    List<STATICRESOURCES> findBySystem_idAndResource_type(SYSTEM system, STATICRESOURCETYPES type);
}
