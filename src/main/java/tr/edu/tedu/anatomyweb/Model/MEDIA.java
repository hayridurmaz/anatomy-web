package tr.edu.tedu.anatomyweb.Model;

import tr.edu.tedu.anatomyweb.Utils.MediaType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "MEDIA")
public class MEDIA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String data_url;

    private String thumbnail_url;

    private String description;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "media_topic",
            joinColumns = {@JoinColumn(name = "media_id")},
            inverseJoinColumns = {@JoinColumn(name = "topic_id")})
    private List<TOPIC> topics = new ArrayList<>();


    @ManyToOne(optional = false/*, cascade = CascadeType.ALL*/)
    @JoinColumn(name = "system_id", nullable = false)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    private SYSTEM system;

    private MediaType media_type;

    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public MEDIA() {
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


    public SYSTEM getSystem() {
        return system;
    }

    public void setSystem(SYSTEM system) {
        this.system = system;
    }

    public MediaType getMediaType() {
        return media_type;
    }

    public void setMediaType(MediaType media_type) {
        this.media_type = media_type;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public List<TOPIC> getTopics() {
        return topics;
    }

    public void setTopics(List<TOPIC> topics) {
        this.topics = topics;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MEDIA medıa = (MEDIA) o;
        return Objects.equals(id, medıa.id) &&
                Objects.equals(data_url, medıa.data_url) &&
                Objects.equals(thumbnail_url, medıa.thumbnail_url) &&
                Objects.equals(description, medıa.description) &&
                Objects.equals(topics, medıa.topics) &&
                Objects.equals(system, medıa.system) &&
                media_type == medıa.media_type &&
                Objects.equals(date, medıa.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data_url, thumbnail_url, description, topics, system, media_type, date);
    }

    @Override
    public String toString() {
        return "MEDIA{" +
                "id=" + id +
                ", data_url='" + data_url + '\'' +
                ", thumbnail_url='" + thumbnail_url + '\'' +
                ", description='" + description + '\'' +
                ", topics=" + topics +
                ", system=" + system +
                ", media_type=" + media_type +
                ", date='" + date + '\'' +
                '}';
    }
}
