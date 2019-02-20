package tr.edu.tedu.anatomyweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.ACCOUNT;
import tr.edu.tedu.anatomyweb.Model.ANSWER;
import tr.edu.tedu.anatomyweb.Repository.AccountRepository;

import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    AccountRepository accountRepository;

    public List<ACCOUNT> findAll(){
        return (List<ACCOUNT>) accountRepository.findAll();
    }

    public ACCOUNT save(ACCOUNT account){
        return accountRepository.save(account);
    }

    public ACCOUNT findById(Long Id){
        return accountRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + Id));
    }

    public void delete(Long Id){
        accountRepository.deleteById(Id);
    }
}
