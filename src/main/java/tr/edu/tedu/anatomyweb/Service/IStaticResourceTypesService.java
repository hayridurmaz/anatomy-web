package tr.edu.tedu.anatomyweb.Service;

import tr.edu.tedu.anatomyweb.Model.QUIZTYPE;
import tr.edu.tedu.anatomyweb.Model.STATICRESOURCETYPES;

import java.util.List;

public interface IStaticResourceTypesService {

    List<STATICRESOURCETYPES> findAll();

    STATICRESOURCETYPES save(STATICRESOURCETYPES srt);

    STATICRESOURCETYPES findById(Long resourceTypeId);

    String delete(Long resourceTypeId);

}
