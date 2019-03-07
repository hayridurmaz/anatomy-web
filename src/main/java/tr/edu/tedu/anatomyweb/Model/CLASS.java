package tr.edu.tedu.anatomyweb.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CLASS")
public class CLASS {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String name;

    @OneToMany(mappedBy = "student_class"/* fetch = FetchType.LAZY */)
    public List<STUDENT> students;


    @OneToOne(optional = false)
    @JoinColumn(name = "teacher_id", nullable = false)
    private TEACHER teacher;
}
