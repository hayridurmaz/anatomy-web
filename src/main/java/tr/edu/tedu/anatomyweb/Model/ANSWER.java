package tr.edu.tedu.anatomyweb.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ANSWER")
public class ANSWER {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String atext;

    @ManyToOne(optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private QUESTION question;

    @Column(name = "question_id", insertable = false, updatable = false)
    private Long question_id;

    public ANSWER() {

    }

    public void setQuestion_id(Long question_id) {
        this.question_id = question_id;
    }

    public Long getQuestion_id() {
        return question_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAtext() {
        return atext;
    }

    public void setAtext(String atext) {
        this.atext = atext;
    }

    public QUESTION getQuestion() {
        return question;
    }

    public void setQuestion(QUESTION question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ANSWER answer = (ANSWER) o;
        return id.equals(answer.id) &&
                atext.equals(answer.atext) &&
                question.equals(answer.question) &&
                question_id.equals(answer.question_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, atext, question, question_id);
    }

    @Override
    public String toString() {
        return "ANSWER{" +
                "id=" + id +
                ", atext='" + atext + '\'' +
                //", question=" + question +
                ", question_id=" + question_id +
                '}';
    }
}
