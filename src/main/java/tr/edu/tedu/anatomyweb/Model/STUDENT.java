package tr.edu.tedu.anatomyweb.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class STUDENT {


    @Id
    private Long ID;
    private String username;
    private int score;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },

            targetEntity = CLASS.class,
            mappedBy = "students")
    @JsonBackReference
    private List<CLASS> students_clases = new ArrayList<>();


    @OneToMany(mappedBy = "givenanswersstudent")
    @JsonIgnore
    private List<GIVENANSWERS> studentgivenanswers = new ArrayList<>();

    public STUDENT() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<CLASS> getStudents_clases() {
        return students_clases;
    }

    public void setStudents_clases(List<CLASS> students_clases) {
        this.students_clases = students_clases;
    }

    public List<GIVENANSWERS> getStudentgivenanswers() {
        return studentgivenanswers;
    }

    public void setStudentgivenanswers(List<GIVENANSWERS> studentgivenanswers) {
        this.studentgivenanswers = studentgivenanswers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        STUDENT student = (STUDENT) o;
        return score == student.score &&
                Objects.equals(ID, student.ID) &&
                Objects.equals(username, student.username) &&
                Objects.equals(students_clases, student.students_clases) &&
                Objects.equals(studentgivenanswers, student.studentgivenanswers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, username, score, students_clases, studentgivenanswers);
    }

    @Override
    public String toString() {
        return "STUDENT{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", score=" + score +
                ", students_clases=" + students_clases +
                '}';
    }
}
