package tr.edu.tedu.anatomyweb.Service;

import tr.edu.tedu.anatomyweb.Model.SYSTEM;

import java.util.List;

public interface ISystemService {

    List<SYSTEM> findAll();

    SYSTEM save(SYSTEM system);

    SYSTEM findById(long systemId);

    String delete(Long systemId);
}
