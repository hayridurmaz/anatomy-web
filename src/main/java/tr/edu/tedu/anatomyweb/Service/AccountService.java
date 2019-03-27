package tr.edu.tedu.anatomyweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.ACCOUNT;
import tr.edu.tedu.anatomyweb.Model.STUDENT;
import tr.edu.tedu.anatomyweb.Model.TEACHER;
import tr.edu.tedu.anatomyweb.Repository.AccountRepository;
import tr.edu.tedu.anatomyweb.Utils.UserRole;

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
                STUDENT isAlreadyExistStudent = studentService.findById(account.getID());
                if (isAlreadyExistStudent != null) {
                    s.setScore(isAlreadyExistStudent.getScore());
                    s.setStudents_clases(isAlreadyExistStudent.getStudents_clases());
                } else {
                    s.setScore(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
                s.setScore(0);
            }
            studentService.save(s);
        }
        if (account.getUserRole() == UserRole.Teacher) {
            System.out.println("TEACHER GİRDİ!");

            TEACHER t = new TEACHER();
            t.setID(savedAccount.getID());
            t.setUsername(savedAccount.getUsername());
            try {
                if (teacherService.findById(account.getID()) != null) {
                    t.setTeachers_clases(teacherService.findById(account.getID()).getTeachers_clases());
                }
            } catch (Exception e) {
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
                if (studentService.delete(Id).contains("Cannot delete:")) {
                    return "Cannot delete, student belongs to a class";
                }
            }
            if (account.getUserRole() == UserRole.Teacher) {
                if (teacherService.delete(Id).contains("Cannot delete:")) {
                    return "Cannot delete, teacher belongs to a class";
                }
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
