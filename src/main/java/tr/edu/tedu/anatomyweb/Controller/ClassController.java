package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Model.CLASS;
import tr.edu.tedu.anatomyweb.Model.STUDENT;
import tr.edu.tedu.anatomyweb.Model.TEACHER;
import tr.edu.tedu.anatomyweb.Service.IClassService;
import tr.edu.tedu.anatomyweb.Service.IStudentService;
import tr.edu.tedu.anatomyweb.Service.ITeacherService;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@CrossOrigin
@RestController
public class ClassController {


    @Autowired
    IClassService classService;

    @Autowired
    IStudentService studentService;

    @Autowired
    ITeacherService teacherService;


    @GetMapping("/Classes")
    List<CLASS> getClasses() {
        return classService.findAll();
    }

    @GetMapping(("/Classes/{Id}"))
    CLASS getAccountById(@PathVariable Long Id) {
        return classService.findById(Id);
    }


    @PostMapping("/Classes")
    public CLASS createAccount(@Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        CLASS c = new CLASS();
        c.setName(parser.get("name").toString());

        Set<STUDENT> students = new HashSet<>();
        List<Object> student_ids = factory.parseList(parser.get("student_ids").toString());
        for (Object o :
                student_ids) {
            STUDENT s = studentService.findById(Long.parseLong(o.toString()));
            students.add(s);
        }

        c.setStudents(students);

        Set<TEACHER> teachers = new HashSet<>();
        List<Object> teacher_ids = factory.parseList(parser.get("teacher_ids").toString());
        for (Object o :
                teacher_ids) {
            TEACHER t = teacherService.findById(Long.parseLong(o.toString()));
            teachers.add(t);
        }

        c.setTeachers(teachers);

        return classService.save(c);
    }

    @PutMapping("/Classes/{Id}")
    public CLASS updateAccount(@PathVariable Long Id, @Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        CLASS c = classService.findById(Id);


        if (parser.get("name") != null) {
            c.setName(parser.get("name").toString());
        }

        if (parser.get("student_ids") != null) {
            Set<STUDENT> students = c.getStudents();
            List<Object> student_ids = factory.parseList(parser.get("student_ids").toString());
            for (Object o :
                    student_ids) {
                STUDENT s = studentService.findById(Long.parseLong(o.toString()));
                if (!students.contains(s)) {
                    students.add(s);
                }
            }
        }

        if (parser.get("teacher_ids") != null) {
            Set<TEACHER> teachers = c.getTeachers();
            List<Object> teacher_ids = factory.parseList(parser.get("teacher_ids").toString());
            for (Object o :
                    teacher_ids) {
                TEACHER t = teacherService.findById(Long.parseLong(o.toString()));
                if (!teachers.contains(t)) {
                    teachers.add(t);
                }
            }
        }


        return classService.save(c);
    }

    @DeleteMapping("/Classes/{Id}")
    public String deleteClass(@PathVariable Long Id) {
        return classService.delete(Id);
    }


}