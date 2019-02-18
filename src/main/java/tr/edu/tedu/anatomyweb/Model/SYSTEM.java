package tr.edu.tedu.anatomyweb.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SYSTEM")
public class SYSTEM {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String NAME;

    public SYSTEM() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
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
        SYSTEM system = (SYSTEM) o;
        return Objects.equals(ID, system.ID) && Objects.equals(NAME, system.NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, NAME);
    }

    @Override
    public String toString() {
        return "SYSTEM{" + "ID=" + ID + ", NAME='" + NAME + '\'' + '}';
    }
}
