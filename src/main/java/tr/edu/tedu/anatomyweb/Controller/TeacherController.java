package tr.edu.tedu.anatomyweb.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tr.edu.tedu.anatomyweb.Model.TEACHER;
import tr.edu.tedu.anatomyweb.Service.ITeacherService;

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


}
