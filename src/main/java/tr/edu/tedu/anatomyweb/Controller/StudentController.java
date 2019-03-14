package tr.edu.tedu.anatomyweb.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Model.STUDENT;
import tr.edu.tedu.anatomyweb.Service.IStudentService;

import javax.validation.Valid;
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

    @PostMapping("/Students")
    public STUDENT createStudent(@Valid @RequestBody STUDENT student) {
        //TODO: Parse a json and add the teacher or test whether current impl works
        return studentService.save(student);
    }

    @PutMapping("/Students/{Id}")
    public STUDENT updateStudent(@PathVariable Long Id, @Valid @RequestBody STUDENT sRequest) {
        //TODO: Parse a json and update teacher
        return null;
    }

    @DeleteMapping("/Students/{Id}")
    public String deleteStudent(@PathVariable Long Id) {
        return studentService.delete(Id);
    }

}
