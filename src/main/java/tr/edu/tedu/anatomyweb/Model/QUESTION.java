package tr.edu.tedu.anatomyweb.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "QUESTION")
public class QUESTION {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String qtext;
    private String hint;


    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    public List<ANSWER> answers;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "image_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private IMAGE image;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "topic_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private TOPIC topic;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "quiz_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private QUIZ quiz;


    public QUESTION() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQtext() {
        return qtext;
    }

    public void setQtext(String qtext) {
        this.qtext = qtext;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public List<ANSWER> getAnswers() {
        return answers;
    }

    public void setAnswers(List<ANSWER> answers) {
        this.answers = answers;
    }

    public IMAGE getImage() {
        return image;
    }

    public void setImage(IMAGE image) {
        this.image = image;
    }

    public TOPIC getTopic() {
        return topic;
    }

    public void setTopic(TOPIC topic) {
        this.topic = topic;
    }

    public QUIZ getQuiz() {
        return quiz;
    }

    public void setQuiz(QUIZ quiz) {
        this.quiz = quiz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QUESTION question = (QUESTION) o;
        return Objects.equals(id, question.id) &&
                Objects.equals(qtext, question.qtext) &&
                Objects.equals(hint, question.hint) &&
                Objects.equals(answers, question.answers) &&
                Objects.equals(image, question.image) &&
                Objects.equals(topic, question.topic) &&
                Objects.equals(quiz, question.quiz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, qtext, hint, answers, image, topic, quiz);
    }

    @Override
    public String toString() {
        return "QUESTION{" +
                "id=" + id +
                ", qtext='" + qtext + '\'' +
                ", hint='" + hint + '\'' +
                ", answers=" + answers +
                ", image=" + image +
                ", topic=" + topic +
                ", quiz=" + quiz +
                '}';
    }
}
