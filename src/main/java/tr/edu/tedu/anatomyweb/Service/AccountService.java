package tr.edu.tedu.anatomyweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.ACCOUNT;
import tr.edu.tedu.anatomyweb.Model.CLASS;
import tr.edu.tedu.anatomyweb.Model.STUDENT;
import tr.edu.tedu.anatomyweb.Model.TEACHER;
import tr.edu.tedu.anatomyweb.Repository.AccountRepository;
import tr.edu.tedu.anatomyweb.Repository.StudentRepository;
import tr.edu.tedu.anatomyweb.Repository.TeacherRepository;
import tr.edu.tedu.anatomyweb.Utils.UserRole;

import java.util.HashSet;
import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    public List<ACCOUNT> findAll() {
        return accountRepository.findAll();
    }

    public ACCOUNT save(ACCOUNT account) {
        ACCOUNT savedAccount = accountRepository.save(account);
        if (account.getUserRole() == UserRole.Student) {
            STUDENT s = new STUDENT();
            s.setID(savedAccount.getID());
            s.setUsername(savedAccount.getUsername());
            s.setScore(0);
            s.setClases(new HashSet<CLASS>());
            studentRepository.save(s);
        }
        if (account.getUserRole() == UserRole.Teacher) {
            TEACHER t = new TEACHER();
            t.setID(savedAccount.getID());
            t.setUsername(savedAccount.getUsername());
            t.setClases(new HashSet<CLASS>());
            teacherRepository.save(t);
        }
        return savedAccount;
    }

    public ACCOUNT findById(Long Id) {
        return accountRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + Id));
    }

    public String delete(Long Id) {
        try {
            accountRepository.deleteById(Id);
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
