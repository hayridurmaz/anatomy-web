package tr.edu.tedu.anatomyweb.Model;


import javax.persistence.*;

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

    @Override
    public String toString() {
        return "QUIZTYPE{" +
                "ID=" + ID +
                ", NAME='" + NAME + '\'' +
                '}';
    }
}
