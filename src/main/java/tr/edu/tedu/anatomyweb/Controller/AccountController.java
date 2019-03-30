package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Exception.ResourceAlreadyFoundException;
import tr.edu.tedu.anatomyweb.Model.ACCOUNT;
import tr.edu.tedu.anatomyweb.Model.STUDENT;
import tr.edu.tedu.anatomyweb.Service.IAccountService;
import tr.edu.tedu.anatomyweb.Service.IStudentService;
import tr.edu.tedu.anatomyweb.Utils.UserRole;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class AccountController {


    @Autowired
    IAccountService accountService;

    @Autowired
    IStudentService studentService;

    @GetMapping("/Accounts")
    List<ACCOUNT> getAccounts() {
        return accountService.findAll();
    }

    @GetMapping(("/Accounts/{AccountId}"))
    ACCOUNT getAccountById(@PathVariable Long AccountId) {
        ACCOUNT a = accountService.findById(AccountId);
        return a;
    }

    @GetMapping(("/Accounts/"))
    ACCOUNT getAccountByUserName(@RequestParam(value = "username") String UserName) {
        ACCOUNT a = accountService.findByUsername(UserName);
        return a;
    }

    @GetMapping(("/Login"))
    ACCOUNT Login(@RequestParam(value = "username") String UserName, @RequestParam(value = "password") String password) {

        ACCOUNT a = accountService.findByUsername(UserName);
        if(a==null){
            ACCOUNT acc = new ACCOUNT();
            acc.setName("There is no such user");
            return acc;
        }
        if (a.getPassword().equals(password) && a.getUserRole().equals(UserRole.Teacher)) {
            return a;
        } else if (!a.getPassword().equals(password)) {
            ACCOUNT acc = new ACCOUNT();
            acc.setName("Password not correct");
            return acc;
        } else {
            ACCOUNT acc = new ACCOUNT();
            acc.setName("You do not have permission to login");
            return acc;
        }

    }

    @PostMapping("/Accounts")
    public ACCOUNT createAccount(@Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        System.out.println(parser.keySet().toString());
        if (getAccountByUserName(parser.get("username").toString()) != null) {
            throw new ResourceAlreadyFoundException("Username is already taken!");
        } else {
            ACCOUNT a = new ACCOUNT();
            a.setMail(parser.get("mail").toString());
            a.setPassword(parser.get("password").toString());
            a.setUsername(parser.get("username").toString());
            a.setUserRole(UserRole.valueOf(parser.get("userRole").toString()));
            a.setGender(parser.get("gender").toString());
            a.setName(parser.get("name").toString());
            a.setPhone_number(parser.get("phoneNumber").toString());
            return accountService.save(a);
        }

    }

    @PutMapping("/Accounts/{AccountId}")
    public ACCOUNT updateAccount(@PathVariable Long AccountId, @Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        ACCOUNT a = accountService.findById(AccountId);


        if (parser.get("gender") != null) {
            a.setGender(parser.get("gender").toString());
        }
        if (parser.get("name") != null) {
            a.setName(parser.get("name").toString());
        }
        if (parser.get("phoneNumber") != null) {
            a.setPhone_number(parser.get("phoneNumber").toString());
        }
        if (parser.get("mail") != null) {
            a.setMail(parser.get("mail").toString());
        }
        if (parser.get("password") != null) {
            a.setPassword(parser.get("password").toString());
        }
        if (parser.get("username") != null) {
            a.setUsername(parser.get("username").toString());
        }
        if (parser.get("userRole") != null) {
            //a.setUserRole((UserRole) parser.get("userRole")); //Changing user role is not allowed!
        }
        if (parser.get("addScore") != null) {
            STUDENT s = studentService.findById(a.getID());
            s.setScore(s.getScore() + Integer.parseInt(parser.get("addScore").toString()));
            studentService.save(s);
        }

        return accountService.save(a);
    }

    @DeleteMapping("/Accounts/{AccountId}")
    public String deleteAccount(@PathVariable Long AccountId) {
        return accountService.delete(AccountId);
    }


}
