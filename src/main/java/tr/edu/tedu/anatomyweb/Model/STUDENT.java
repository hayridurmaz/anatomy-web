package tr.edu.tedu.anatomyweb.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class STUDENT {


    @Id
    private Long ID;
    private String username;
    private int score;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "students")
    private Set<CLASS> clases = new HashSet<>();


}
