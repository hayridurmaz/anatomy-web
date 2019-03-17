package tr.edu.tedu.anatomyweb.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "QUIZ")
public class QUIZ {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @OneToMany(mappedBy = "quiz"/* fetch = FetchType.LAZY */)
    public List<QUESTION> questions;


    @ManyToOne(optional = false)
    @JoinColumn(name = "quiz_type_id", nullable = false)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    // @JsonIgnore
    private QUIZTYPE quiztype;

    @ManyToOne(/* = FetchType.LAZY */optional = false)
    @JoinColumn(name = "system_id", nullable = false)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    // @JsonIgnore
    private SYSTEM system;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            targetEntity = CLASS.class,
            mappedBy = "quizzes")
    @JsonBackReference
    private List<CLASS> quiz_clases = new ArrayList<>();


    @OneToMany(mappedBy = "givenanswersquiz")
    @JsonIgnore
    private List<GIVENANSWERS> quizgivenanswers = new ArrayList<>();

    public QUIZ() {

    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public QUIZTYPE getQuiztype() {
        return quiztype;
    }

    public void setQuiztype(QUIZTYPE quiztype) {
        this.quiztype = quiztype;
    }

    public SYSTEM getSystem() {
        return system;
    }

    public void setSystem(SYSTEM system) {
        this.system = system;
    }

    public List<QUESTION> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QUESTION> questions) {
        this.questions = questions;
    }

    public List<CLASS> getQuiz_clases() {
        return quiz_clases;
    }

    public void setQuiz_clases(List<CLASS> quiz_clases) {
        this.quiz_clases = quiz_clases;
    }

    public List<GIVENANSWERS> getQuizgivenanswers() {
        return quizgivenanswers;
    }

    public void setQuizgivenanswers(List<GIVENANSWERS> quizgivenanswers) {
        this.quizgivenanswers = quizgivenanswers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QUIZ quız = (QUIZ) o;
        return Objects.equals(ID, quız.ID) &&
                Objects.equals(quiztype, quız.quiztype) &&
                Objects.equals(system, quız.system) &&
                Objects.equals(questions, quız.questions) &&
                Objects.equals(quiz_clases, quız.quiz_clases) &&
                Objects.equals(quizgivenanswers, quız.quizgivenanswers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, quiztype, system, questions, quiz_clases, quizgivenanswers);
    }

    @Override
    public String toString() {
        return "QUIZ{" + "ID=" + ID + ", quiztype=" + quiztype + ", system=" + system + ", questions=" + questions
                + '}';
    }
}
