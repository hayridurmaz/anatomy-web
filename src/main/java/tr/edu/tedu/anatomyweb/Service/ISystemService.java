package tr.edu.tedu.anatomyweb.Service;

import tr.edu.tedu.anatomyweb.Model.SYSTEM;

import java.util.List;

public interface ISystemService {

    public List<SYSTEM> findAll();

    public SYSTEM save(SYSTEM system);

    public SYSTEM findById(long systemId);

    public void delete(Long systemId);
}
