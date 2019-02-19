package tr.edu.tedu.anatomyweb.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "QUIZTYPE")
public class QUIZTYPE {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String NAME;

    public QUIZTYPE(String NAME) {
        this.NAME = NAME;
    }

    public QUIZTYPE() {
    }

    public Long getID() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        QUIZTYPE quiztype = (QUIZTYPE) o;
        return ID.equals(quiztype.ID) && Objects.equals(NAME, quiztype.NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, NAME);
    }

    @Override
    public String toString() {
        return "QUIZTYPE{" + "ID=" + ID + ", NAME='" + NAME + '\'' + '}';
    }
}
