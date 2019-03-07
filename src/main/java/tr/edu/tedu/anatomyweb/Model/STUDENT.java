package tr.edu.tedu.anatomyweb.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class STUDENT extends USER{


    @ManyToOne(optional = false)
    @JoinColumn(name = "class_id", nullable = false)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private CLASS student_class;


}
