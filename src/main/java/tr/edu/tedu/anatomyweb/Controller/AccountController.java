package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Model.ACCOUNT;
import tr.edu.tedu.anatomyweb.Service.IAccountService;
import tr.edu.tedu.anatomyweb.Utils.UserRole;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class AccountController {


    @Autowired
    IAccountService accountService;

    @GetMapping("/Accounts")
    List<ACCOUNT> getAccounts() {
        return accountService.findAll();
    }

    @GetMapping(("/Accounts/{AccountId}"))
    ACCOUNT getAccountById(@PathVariable Long AccountId) {
        ACCOUNT a = accountService.findById(AccountId);
        return a;
    }

    @PostMapping("/Accounts")
    public ACCOUNT createAccount(@Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        ACCOUNT a = new ACCOUNT();
        a.setMail(parser.get("mail").toString());
        a.setPassword(parser.get("password").toString());
        a.setUsername(parser.get("username").toString());
        a.setUserRole((UserRole) parser.get("userRole"));
        return accountService.save(a);
    }

    @PutMapping("/Accounts/{AccountId}")
    public ACCOUNT updateAccount(@PathVariable Long AccountId, @Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        ACCOUNT a = accountService.findById(AccountId);

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
            a.setUserRole((UserRole) parser.get("userRole"));
        }

        return accountService.save(a);
    }

    @DeleteMapping("/Accounts/{AccountId}")
    public String deleteAccount(@PathVariable Long AccountId) {
        return accountService.delete(AccountId);
    }


}
