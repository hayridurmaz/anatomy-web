package tr.edu.tedu.anatomyweb.Service;

import tr.edu.tedu.anatomyweb.Model.ACCOUNT;

import java.util.List;

public interface IAccountService {
    List<ACCOUNT> findAll();

    ACCOUNT save(ACCOUNT account);

    ACCOUNT findById(Long Id);

    String delete(Long Id);
}
