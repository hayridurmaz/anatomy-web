package tr.edu.tedu.anatomyweb.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
            mappedBy = "students")
    private Set<CLASS> clases = new HashSet<>();

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

    public Set<CLASS> getClases() {
        return clases;
    }

    public void setClases(Set<CLASS> clases) {
        this.clases = clases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        STUDENT student = (STUDENT) o;
        return score == student.score &&
                Objects.equals(ID, student.ID) &&
                Objects.equals(username, student.username) &&
                Objects.equals(clases, student.clases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, username, score, clases);
    }

    @Override
    public String toString() {
        return "STUDENT{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", score=" + score +
                ", clases=" + clases +
                '}';
    }
}
