package tr.edu.tedu.anatomyweb.Model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class TEACHER extends USER {


    @OneToOne(optional = false)
    @JoinColumn(name = "class_id", nullable = false)
    private CLASS teacher_class;

}
