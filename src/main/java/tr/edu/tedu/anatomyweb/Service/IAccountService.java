package tr.edu.tedu.anatomyweb.Service;

import tr.edu.tedu.anatomyweb.Model.ACCOUNT;
import tr.edu.tedu.anatomyweb.Model.ANSWER;

import java.util.List;

public interface IAccountService {
    public List<ACCOUNT> findAll();

    public ACCOUNT save(ACCOUNT account);

    public ACCOUNT findById(Long Id);

    public String delete(Long Id);
}
