package tr.edu.tedu.anatomyweb.Model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "IMAGE")
public class IMAGE {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String data_url;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id", nullable = false)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private TOPIC topic;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "system_id", nullable = false)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private SYSTEM system;

    public IMAGE() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData_url() {
        return data_url;
    }

    public void setData_url(String data_url) {
        this.data_url = data_url;
    }

    public TOPIC getTopic() {
        return topic;
    }

    public void setTopic(TOPIC topic) {
        this.topic = topic;
    }

    public SYSTEM getSystem() {
        return system;
    }

    public void setSystem(SYSTEM system) {
        this.system = system;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        IMAGE image = (IMAGE) o;
        return Objects.equals(id, image.id) && Objects.equals(data_url, image.data_url)
                && Objects.equals(topic, image.topic) && Objects.equals(system, image.system);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data_url, topic, system);
    }

    @Override
    public String toString() {
        return "IMAGE{" + "id=" + id + ", data_url='" + data_url + '\'' + ", topic=" + topic + ", system=" + system
                + '}';
    }
}
