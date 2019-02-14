package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class HelloController  {

    @RequestMapping("/")
    String home() {
        return "Hello World from the server!";
    }
}
