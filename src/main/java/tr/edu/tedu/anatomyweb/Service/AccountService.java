package tr.edu.tedu.anatomyweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.ACCOUNT;
import tr.edu.tedu.anatomyweb.Model.CLASS;
import tr.edu.tedu.anatomyweb.Model.STUDENT;
import tr.edu.tedu.anatomyweb.Model.TEACHER;
import tr.edu.tedu.anatomyweb.Repository.AccountRepository;
import tr.edu.tedu.anatomyweb.Utils.UserRole;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    IStudentService studentService;

    @Autowired
    ITeacherService teacherService;

    public List<ACCOUNT> findAll() {
        return accountRepository.findAll();
    }

    public ACCOUNT save(ACCOUNT account) {
        ACCOUNT savedAccount = accountRepository.save(account);
        if (account.getUserRole() == UserRole.Student) {
            System.out.println("STUDENT GİRDİ!");
            STUDENT s = new STUDENT();
            s.setID(savedAccount.getID());
            s.setUsername(savedAccount.getUsername());
            try {
                System.out.println(studentService.findById(account.getID()));
                if (studentService.findById(account.getID()) != null) {
                    s.setScore(studentService.findById(account.getID()).getScore());
                    s.setClases(studentService.findById(account.getID()).getClases());
                }
            } catch (Exception e) {
                s.setScore(0);
                s.setClases(new ArrayList<>());
            }
            studentService.save(s);
        }
        if (account.getUserRole() == UserRole.Teacher) {
            System.out.println("TEACHER GİRDİ!");

            TEACHER t = new TEACHER();
            t.setID(savedAccount.getID());
            t.setUsername(savedAccount.getUsername());
            try {
                System.out.println(teacherService.findById(account.getID()));
                if (teacherService.findById(account.getID()) != null) {
                    t.setClases(teacherService.findById(account.getID()).getClases());
                }
            } catch (Exception e) {
                t.setClases(new HashSet<CLASS>());
            }
            teacherService.save(t);
        }
        System.out.println("ACCOUNT SERVİCE SONU!");

        return savedAccount;
    }

    public ACCOUNT findById(Long Id) {
        return accountRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + Id));
    }

    public ACCOUNT findByUsername(String Username) {
        return accountRepository.findByUsername(Username);
    }

    public String delete(Long Id) {
        try {
            ACCOUNT account = findById(Id);
            if (account.getUserRole() == UserRole.Student) {
                studentService.delete(Id);
            }
            if (account.getUserRole() == UserRole.Teacher) {
                teacherService.delete(Id);
            }
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
