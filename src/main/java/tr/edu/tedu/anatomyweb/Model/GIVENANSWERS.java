package tr.edu.tedu.anatomyweb.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "GIVENANSWERS")
public class GIVENANSWERS {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private STUDENT givenanswers_student;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private QUIZ givenanswers_quiz;

    private String json;
    private Integer grade;


    public GIVENANSWERS() {
    }

    public STUDENT getGivenanswers_student() {
        return givenanswers_student;
    }

    public void setGivenanswers_student(STUDENT givenanswers_student) {
        this.givenanswers_student = givenanswers_student;
    }

    public QUIZ getGivenanswers_quiz() {
        return givenanswers_quiz;
    }

    public void setGivenanswers_quiz(QUIZ givenanswers_quiz) {
        this.givenanswers_quiz = givenanswers_quiz;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GIVENANSWERS that = (GIVENANSWERS) o;
        return Objects.equals(givenanswers_student, that.givenanswers_student) &&
                Objects.equals(givenanswers_quiz, that.givenanswers_quiz) &&
                Objects.equals(json, that.json) &&
                Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(givenanswers_student, givenanswers_quiz, json, grade);
    }

    @Override
    public String toString() {
        return "GIVENANSWERS{" +
                "givenanswers_student=" + givenanswers_student +
                ", givenanswers_quiz=" + givenanswers_quiz +
                ", json='" + json + '\'' +
                ", grade=" + grade +
                '}';
    }
}
