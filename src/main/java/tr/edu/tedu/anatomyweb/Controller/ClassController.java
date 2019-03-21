package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Model.CLASS;
import tr.edu.tedu.anatomyweb.Model.QUIZ;
import tr.edu.tedu.anatomyweb.Model.STUDENT;
import tr.edu.tedu.anatomyweb.Model.TEACHER;
import tr.edu.tedu.anatomyweb.Service.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class ClassController {


    @Autowired
    IClassService classService;

    @Autowired
    IStudentService studentService;

    @Autowired
    ITeacherService teacherService;

    @Autowired
    IAccountService accountService;

    @Autowired
    IQuizService quizService;


    @GetMapping("/Classes/")
    List<CLASS> getClasses(@RequestParam(value = "userid") Long userid) {
        TEACHER t = teacherService.findById(userid);
        return classService.findAllByTeachers(t);
    }

    @GetMapping(("/Classes/{Id}"))
    CLASS getClassesById(@PathVariable Long Id) {
        return classService.findById(Id);
    }


    @PostMapping("/Classes")
    public CLASS createClass(@Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        CLASS c = new CLASS();
        c.setName(parser.get("name").toString());

        List<STUDENT> students = new ArrayList<>();
        List<Object> student_ids = factory.parseList(parser.get("student_ids").toString());
        for (Object o :
                student_ids) {
            STUDENT s = studentService.findById(Long.parseLong(o.toString()));
            students.add(s);
        }

        c.setStudents(students);

        List<TEACHER> teachers = new ArrayList<>();
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
    public CLASS updateClass(@PathVariable Long Id, @Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        CLASS c = classService.findById(Id);


        if (parser.get("name") != null) {
            c.setName(parser.get("name").toString());
        }

        if (parser.get("student_ids") != null) {
            List<STUDENT> students = c.getStudents();
            List<Object> student_ids = factory.parseList(parser.get("student_ids").toString());
            for (Object o :
                    student_ids) {
                STUDENT s = studentService.findById(Long.parseLong(o.toString()));
                if (!students.contains(s)) {
                    students.add(s);
                }
            }
        }

        if (parser.get("remove_student_ids") != null) {
            List<STUDENT> students = c.getStudents();
            List<Object> remove_student_ids = factory.parseList(parser.get("remove_student_ids").toString());
            for (Object o :
                    remove_student_ids) {
                STUDENT s = studentService.findById(Long.parseLong(o.toString()));
                students.remove(s);
            }
        }

        if (parser.get("teacher_ids") != null) {
            List<TEACHER> teachers = c.getTeachers();
            List<Object> teacher_ids = factory.parseList(parser.get("teacher_ids").toString());
            for (Object o :
                    teacher_ids) {
                TEACHER t = teacherService.findById(Long.parseLong(o.toString()));
                if (!teachers.contains(t)) {
                    teachers.add(t);
                }
            }
        }


        if (parser.get("remove_teacher_ids") != null) {
            List<TEACHER> teachers = c.getTeachers();
            List<Object> teacher_ids = factory.parseList(parser.get("remove_teacher_ids").toString());
            for (Object o :
                    teacher_ids) {
                TEACHER t = teacherService.findById(Long.parseLong(o.toString()));
                teachers.remove(t);
            }
        }

        if (parser.get("quiz_ids") != null) {
            List<QUIZ> quizzes = c.getQuizzes();
            List<Object> quiz_ids = factory.parseList(parser.get("quiz_ids").toString());
            for (Object o :
                    quiz_ids) {
                QUIZ t = quizService.findById(Long.parseLong(o.toString()));
                quizzes.add(t);
            }
        }

        if (parser.get("remove_quiz_ids") != null) {
            List<QUIZ> quizzes = c.getQuizzes();
            List<Object> remove_quiz_ids = factory.parseList(parser.get("remove_quiz_ids").toString());
            for (Object o :
                    remove_quiz_ids) {
                QUIZ t = quizService.findById(Long.parseLong(o.toString()));
                quizzes.remove(t);
            }
        }

        return classService.save(c);
    }

    @DeleteMapping("/Classes/{Id}")
    public String deleteClass(@PathVariable Long Id) {
        return classService.delete(Id);
    }


}
