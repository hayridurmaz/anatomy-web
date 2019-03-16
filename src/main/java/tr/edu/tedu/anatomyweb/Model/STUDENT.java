package tr.edu.tedu.anatomyweb.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
            targetEntity = CLASS.class,
            mappedBy = "students")
    @JsonBackReference
    private List<CLASS> students_clases = new ArrayList<>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        STUDENT student = (STUDENT) o;
        return score == student.score &&
                Objects.equals(ID, student.ID) &&
                Objects.equals(username, student.username) &&
                Objects.equals(students_clases, student.students_clases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, username, score, students_clases);
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
