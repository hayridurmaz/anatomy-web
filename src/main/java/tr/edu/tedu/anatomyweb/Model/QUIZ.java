package tr.edu.tedu.anatomyweb.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "QUIZ")
public class QUIZ {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private Long TYPE;
    private Long SYSTEMID;

    public QUIZ() {

    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getTYPE() {
        return TYPE;
    }

    public void setTYPE(Long TYPE) {
        this.TYPE = TYPE;
    }

    public Long getSYSTEMID() {
        return SYSTEMID;
    }

    public void setSYSTEMID(Long SYSTEMID) {
        this.SYSTEMID = SYSTEMID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QUIZ quiz = (QUIZ) o;
        return Objects.equals(ID, quiz.ID) &&
                Objects.equals(TYPE, quiz.TYPE) &&
                Objects.equals(SYSTEMID, quiz.SYSTEMID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, TYPE, SYSTEMID);
    }

    @Override
    public String toString() {
        return "QUIZ{" +
                "ID=" + ID +
                ", TYPE=" + TYPE +
                ", SYSTEMID=" + SYSTEMID +
                '}';
    }
}
