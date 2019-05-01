package tr.edu.tedu.anatomyweb.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "STATICRESOURCETYPES ")
public class STATICRESOURCETYPES {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    @Column(name = "type", nullable = false)
    private String type;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "STATICRESOURCETYPES{" +
                "ID=" + ID +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        STATICRESOURCETYPES that = (STATICRESOURCETYPES) o;
        return getID().equals(that.getID()) &&
                getType().equals(that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getType());
    }
}
