package tr.edu.tedu.anatomyweb.Model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CORRECTANSWER")
public class CORRECTANSWER {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    private QUESTION question;

    @OneToOne(optional = false)
    @JoinColumn(name = "answer_id", nullable = false)
    private ANSWER answer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QUESTION getQuestion() {
        return question;
    }

    public void setQuestion(QUESTION question) {
        this.question = question;
    }

    public ANSWER getAnswer() {
        return answer;
    }

    public void setAnswer(ANSWER answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CORRECTANSWER that = (CORRECTANSWER) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(question, that.question) &&
                Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer);
    }


    @Override
    public String toString() {
        return "CORRECTANSWER{" +
                "id=" + id +
                ", question=" + question +
                ", answer=" + answer +
                '}';
    }
}
