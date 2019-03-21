package tr.edu.tedu.anatomyweb.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "GIVENANSWERS")
public class GIVENANSWERS {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private STUDENT givenanswersstudent;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    @JsonIgnore
    private QUIZ givenanswersquiz;

    private String json;
    private Integer grade;


    public GIVENANSWERS() {
    }

    public STUDENT getGivenanswersstudent() {
        return givenanswersstudent;
    }

    public void setGivenanswersstudent(STUDENT givenanswersstudent) {
        this.givenanswersstudent = givenanswersstudent;
    }

    public QUIZ getGivenanswersquiz() {
        return givenanswersquiz;
    }

    public void setGivenanswersquiz(QUIZ givenanswersquiz) {
        this.givenanswersquiz = givenanswersquiz;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GIVENANSWERS that = (GIVENANSWERS) o;
        return Objects.equals(ID, that.ID) &&
                Objects.equals(givenanswersstudent, that.givenanswersstudent) &&
                Objects.equals(givenanswersquiz, that.givenanswersquiz) &&
                Objects.equals(json, that.json) &&
                Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, givenanswersstudent, givenanswersquiz, json, grade);
    }

    @Override
    public String toString() {
        return "GIVENANSWERS{" +
                "ID=" + ID +
                ", givenanswersstudent=" + givenanswersstudent +
                ", givenanswersquiz=" + givenanswersquiz +
                ", json='" + json + '\'' +
                ", grade=" + grade +
                '}';
    }
}
