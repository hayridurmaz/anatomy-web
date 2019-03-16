package tr.edu.tedu.anatomyweb.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "CLASS")
public class CLASS {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "student_class",
            joinColumns = {@JoinColumn(name = "class_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private Set<STUDENT> students = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "teacher_class",
            joinColumns = {@JoinColumn(name = "class_id")},
            inverseJoinColumns = {@JoinColumn(name = "teacher_id")})
    private Set<TEACHER> teachers = new HashSet<>();


    public CLASS() {
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

    public Set<STUDENT> getStudents() {
        return students;
    }

    public void setStudents(Set<STUDENT> students) {
        this.students = students;
    }

    public Set<TEACHER> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<TEACHER> teachers) {
        this.teachers = teachers;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CLASS aClass = (CLASS) o;
        return Objects.equals(Id, aClass.Id) &&
                Objects.equals(name, aClass.name) &&
                Objects.equals(students, aClass.students) &&
                Objects.equals(teachers, aClass.teachers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, students, teachers);
    }

    @Override
    public String toString() {
        return "CLASS{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", students=" + students +
                ", teachers=" + teachers +
                '}';
    }
}
