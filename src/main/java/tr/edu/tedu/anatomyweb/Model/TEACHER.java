package tr.edu.tedu.anatomyweb.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.*;

@Entity
public class TEACHER {


    @Id
    private Long ID;
    private String username;


    @ManyToMany(fetch = FetchType.LAZY,
            targetEntity = CLASS.class,
            mappedBy = "teachers")
    @JsonBackReference
    private List<CLASS> teachers_clases = new ArrayList<>();

    public TEACHER() {
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

    public List<CLASS> getTeachers_clases() {
        return teachers_clases;
    }

    public void setTeachers_clases(List<CLASS> teachers_clases) {
        this.teachers_clases = teachers_clases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TEACHER teacher = (TEACHER) o;
        return Objects.equals(ID, teacher.ID) &&
                Objects.equals(username, teacher.username) &&
                Objects.equals(teachers_clases, teacher.teachers_clases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, username, teachers_clases);
    }

    @Override
    public String toString() {
        return "TEACHER{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", teachers_clases=" + teachers_clases +
                '}';
    }
}
