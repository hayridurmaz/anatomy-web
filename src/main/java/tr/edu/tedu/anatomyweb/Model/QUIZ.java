package tr.edu.tedu.anatomyweb.Model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "QUIZ")
public class QUIZ {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

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

    @OneToMany(mappedBy = "quiz"/* fetch = FetchType.LAZY */)
    public List<QUESTION> questions;

    @JoinColumn(name = "header", nullable = false)
    public String header;

    public QUIZ() {

    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        QUIZ quiz = (QUIZ) o;
        return Objects.equals(ID, quiz.ID) && Objects.equals(quiztype, quiz.quiztype)
                && Objects.equals(system, quiz.system) && Objects.equals(questions, quiz.questions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, quiztype, system, questions, header);
    }

    @Override
    public String toString() {
        return "QUIZ{" +
                "ID=" + ID +
                ", quiztype=" + quiztype +
                ", system=" + system +
                ", questions=" + questions +
                ", header='" + header + '\'' +
                '}';
    }
}
