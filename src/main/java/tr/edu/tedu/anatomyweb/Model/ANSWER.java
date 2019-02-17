package tr.edu.tedu.anatomyweb.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "answer")
public class ANSWER {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String atext;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private QUESTION question;

    public ANSWER() {

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
        return Objects.equals(id, answer.id) &&
                Objects.equals(atext, answer.atext) &&
                Objects.equals(question, answer.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, atext, question);
    }

    @Override
    public String toString() {
        return "ANSWER{" +
                "id=" + id +
                ", atext='" + atext + '\'' +
                ", question=" + question +
                '}';
    }
}

