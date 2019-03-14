package tr.edu.tedu.anatomyweb.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Model.TEACHER;
import tr.edu.tedu.anatomyweb.Service.ITeacherService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class TeacherController {

    @Autowired
    ITeacherService teacherService;

    @GetMapping("/Teachers")
    List<TEACHER> getTeachers() {
        return teacherService.findAll();
    }

    @GetMapping("/Teachers/{TeacherId}")
    TEACHER getTeacherById(@PathVariable Long TeacherId) {
        return teacherService.findById(TeacherId);
    }

    @PostMapping("/Teachers")
    public TEACHER createTopic(@Valid @RequestBody TEACHER teacher) {
        //TODO: Parse a json and add the teacher or test whether current impl works
        return teacherService.save(teacher);
    }

    @PutMapping("/Teachers/{Id}")
    public TEACHER updateTopic(@PathVariable Long Id, @Valid @RequestBody TEACHER tRequest) {
        //TODO: Parse a json and update teacher
        return null;
    }

    @DeleteMapping("/Teachers/{Id}")
    public String deleteTopic(@PathVariable Long Id) {
        return teacherService.delete(Id);
    }

}
