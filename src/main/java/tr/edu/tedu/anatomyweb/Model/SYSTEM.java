package tr.edu.tedu.anatomyweb.Model;

import javax.persistence.*;

@Entity
@Table(name = "SYSTEM")
public class SYSTEM {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String NAME;

    public SYSTEM (){
    }

    @Override
    public String toString() {
        return "SYSTEM{" +
                "ID=" + ID +
                ", NAME='" + NAME + '\'' +
                '}';
    }
}
