package tr.edu.tedu.anatomyweb.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tr.edu.tedu.anatomyweb.Model.STUDENT;
import tr.edu.tedu.anatomyweb.Service.IStudentService;

import java.util.List;

@CrossOrigin
@RestController
public class StudentController {

    @Autowired
    IStudentService studentService;

    @GetMapping("/Students")
    List<STUDENT> getStudents() {
        return studentService.findAll();
    }

    @GetMapping("/Students/{Id}")
    STUDENT getStudentById(@PathVariable Long Id) {
        return studentService.findById(Id);
    }


}
