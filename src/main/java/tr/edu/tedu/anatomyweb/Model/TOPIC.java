package tr.edu.tedu.anatomyweb.Model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "TOPIC")
public class TOPIC {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String NAME;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "topics")
    private List <MEDIA> medias = new ArrayList<>();


    public TOPIC() {
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public Long getID() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TOPIC topic = (TOPIC) o;
        return ID.equals(topic.ID) && Objects.equals(NAME, topic.NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, NAME);
    }

    @Override
    public String toString() {
        return "TOPIC{" + "ID=" + ID + ", NAME='" + NAME + '\'' + '}';
    }
}
