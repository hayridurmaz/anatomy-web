package tr.edu.tedu.anatomyweb.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @OneToMany(mappedBy = "question")
    public List<ANSWER> answers;

    @ManyToOne(optional = false)
    @JoinColumn(name = "image_id", nullable = false)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    // @JsonIgnore
    private IMAGE image;

    @OneToOne(optional = false)
    @JoinColumn(name = "correct_answer_id", nullable = false)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    // @JsonIgnore
    private ANSWER correct_answer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "topic_id", nullable = false)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    // @JsonIgnore
    private TOPIC topic;

    @ManyToOne(optional = false)
    @JoinColumn(name = "quiz_id", nullable = false)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private QUIZ quiz;

    @Column(name = "quiz_id", insertable = false, updatable = false)
    private Long quiz_id;


    public QUESTION() {
    }

    public void setQuiz_id(Long quiz_id) {
        this.quiz_id = quiz_id;
    }

    public Long getQuiz_id() {
        return quiz_id;
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
    public String toString() {
        return "QUESTION{" +
                "id=" + id +
                ", qtext='" + qtext + '\'' +
                ", hint='" + hint + '\'' +
                ", answers=" + answers +
                ", image=" + image +
                ", topic=" + topic +
                ", quiz=" + quiz +
                ", quiz_id=" + quiz_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QUESTION question = (QUESTION) o;
        return id.equals(question.id) &&
                qtext.equals(question.qtext) &&
                hint.equals(question.hint) &&
                answers.equals(question.answers) &&
                image.equals(question.image) &&
                topic.equals(question.topic) &&
                quiz.equals(question.quiz) &&
                quiz_id.equals(question.quiz_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, qtext, hint, answers, image, topic, quiz, quiz_id);
    }
}
