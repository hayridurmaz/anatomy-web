package tr.edu.tedu.anatomyweb.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import tr.edu.tedu.anatomyweb.Utils.MediaType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "MEDIA")
public class MEDIA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String data_url;

    private String thumbnail_url;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "media_topic",
            joinColumns = {@JoinColumn(name = "media_id")},
            inverseJoinColumns = {@JoinColumn(name = "topic_id")})
    private Set<TOPIC> topics = new HashSet<>();


    @ManyToOne(optional = false/*, cascade = CascadeType.ALL*/)
    @JoinColumn(name = "system_id", nullable = false)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    private SYSTEM system;


    @Column(name = "system_id", insertable = false, updatable = false)
    private Long system_id;

    public Long getSystem_id() {
        return system_id;
    }

    public void setSystem_id(Long system_id) {
        this.system_id = system_id;
    }

    public MediaType getMedia_type() {
        return media_type;
    }

    public void setMedia_type(MediaType media_type) {
        this.media_type = media_type;
    }

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

    public Set<TOPIC> getTopics() {
        return topics;
    }

    public void setTopics(Set<TOPIC> topics) {
        this.topics = topics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MEDIA media = (MEDIA) o;
        return Objects.equals(id, media.id) &&
                Objects.equals(data_url, media.data_url) &&
                Objects.equals(thumbnail_url, media.thumbnail_url) &&
                Objects.equals(topics, media.topics) &&
                Objects.equals(system, media.system) &&
                media_type == media.media_type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data_url, thumbnail_url, topics, system, media_type);
    }

    @Override
    public String toString() {
        return "MEDIA{" +
                "id=" + id +
                ", data_url='" + data_url + '\'' +
                ", thumbnail_url='" + thumbnail_url + '\'' +
                ", topics=" + topics +
                ", system=" + system +
                ", media_type=" + media_type +
                ", date='" + date + '\'' +
                '}';
    }
}
