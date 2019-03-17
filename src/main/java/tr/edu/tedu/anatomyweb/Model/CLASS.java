package tr.edu.tedu.anatomyweb.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CLASS")
public class CLASS {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },
            targetEntity = STUDENT.class)
    @JoinTable(name = "student_class",
            joinColumns = {@JoinColumn(name = "class_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    @JsonManagedReference
    private List<STUDENT> students = new ArrayList<>();


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            targetEntity = TEACHER.class)
    @JoinTable(name = "teacher_class",
            joinColumns = {@JoinColumn(name = "class_id")},
            inverseJoinColumns = {@JoinColumn(name = "teacher_id")})
    @JsonManagedReference
    private List<TEACHER> teachers = new ArrayList<>();


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            targetEntity = QUIZ.class)
    @JoinTable(name = "quiz_class",
            joinColumns = {@JoinColumn(name = "class_id")},
            inverseJoinColumns = {@JoinColumn(name = "quiz_id")})
    @JsonManagedReference
    private List<QUIZ> quizzes = new ArrayList<>();

    public CLASS() {
    }

    public List<QUIZ> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<QUIZ> quizzes) {
        this.quizzes = quizzes;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<STUDENT> getStudents() {
        return students;
    }

    public void setStudents(List<STUDENT> students) {
        this.students = students;
    }

    public List<TEACHER> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TEACHER> teachers) {
        this.teachers = teachers;
    }


    @Override
    public String toString() {
        return "CLASS{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", students=" + students +
                ", teachers=" + teachers +
                ", quizzes=" + quizzes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CLASS aClass = (CLASS) o;
        return Objects.equals(Id, aClass.Id) &&
                Objects.equals(name, aClass.name) &&
                Objects.equals(students, aClass.students) &&
                Objects.equals(teachers, aClass.teachers) &&
                Objects.equals(quizzes, aClass.quizzes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, students, teachers, quizzes);
    }
}
