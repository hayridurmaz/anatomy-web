package tr.edu.tedu.anatomyweb.Model;

import tr.edu.tedu.anatomyweb.Utils.MediaType;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MEDIA")
public class MEDIA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String data_url;

    private String thumbnail_url;

    @ManyToOne(optional = false /*,cascade = CascadeType.ALL*/)
    @JoinColumn(name = "topic_id", nullable = false)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    private TOPIC topic;

    @ManyToOne(optional = false/*, cascade = CascadeType.ALL*/)
    @JoinColumn(name = "system_id", nullable = false)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    private SYSTEM system;

    private MediaType mediaType;

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

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MEDIA media = (MEDIA) o;
        return Objects.equals(id, media.id) &&
                Objects.equals(data_url, media.data_url) &&
                Objects.equals(topic, media.topic) &&
                Objects.equals(system, media.system) &&
                mediaType == media.mediaType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data_url, topic, system, mediaType);
    }

    @Override
    public String toString() {
        return "MEDIA{" +
                "id=" + id +
                ", data_url='" + data_url + '\'' +
                ", thumbnail_url='" + thumbnail_url + '\'' +
                ", topic=" + topic +
                ", system=" + system +
                ", mediaType=" + mediaType +
                '}';
    }
}
