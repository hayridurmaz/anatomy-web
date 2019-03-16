package tr.edu.tedu.anatomyweb.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TEACHER {


    @Id
    private Long ID;
    private String username;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "teachers")
    private Set<CLASS> clases = new HashSet<>();

}
