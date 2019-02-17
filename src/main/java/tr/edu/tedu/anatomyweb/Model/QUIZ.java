package tr.edu.tedu.anatomyweb.Model;

import javax.persistence.*;

@Entity
@Table(name = "QUIZ")
public class QUIZ {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long  ID;
    private Long TYPE;
    private  Long SYSTEMID;

    public QUIZ(){

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
