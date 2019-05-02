package tr.edu.tedu.anatomyweb.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "STATICRESOURCES")
public class STATICRESOURCES {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long ID;

    @Column(name = "resource_name", nullable = false)
    private String resource_name;

    @Column(name = "target_page", nullable = false)
    private String target_page;

    @Column(name = "button_image")
    private String button_image;

    @Column(name = "button_image_url")
    private String button_image_url;

    @ManyToOne(optional = false/*, cascade = CascadeType.ALL*/)
    @JoinColumn(name = "system_id", nullable = false)
    private SYSTEM system;

    @Column(name = "system_id", insertable = false, updatable = false)
    private Long system_id;

    @ManyToOne(optional = false/*, cascade = CascadeType.ALL*/)
    @JoinColumn(name = "resource_type", nullable = false)
    private STATICRESOURCETYPES resourceType;


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getResource_name() {
        return resource_name;
    }

    public void setResource_name(String resource_name) {
        this.resource_name = resource_name;
    }

    public String getTarget_page() {
        return target_page;
    }

    public void setTarget_page(String target_page) {
        this.target_page = target_page;
    }

    public String getButton_image() {
        return button_image;
    }

    public void setButton_image(String button_image) {
        this.button_image = button_image;
    }

    public String getButton_image_url() {
        return button_image_url;
    }

    public void setButton_image_url(String button_image_url) {
        this.button_image_url = button_image_url;
    }

    public SYSTEM getSystem() {
        return system;
    }

    public void setSystem(SYSTEM system) {
        this.system = system;
    }

    public Long getSystem_id() {
        return system_id;
    }

    public void setSystem_id(Long system_id) {
        this.system_id = system_id;
    }

    public STATICRESOURCETYPES getResource_type() {
        return resourceType;
    }

    public void setResource_type(STATICRESOURCETYPES resource_type) {
        this.resourceType = resource_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        STATICRESOURCES that = (STATICRESOURCES) o;
        return getID().equals(that.getID()) &&
                getResource_name().equals(that.getResource_name()) &&
                getTarget_page().equals(that.getTarget_page()) &&
                Objects.equals(getButton_image(), that.getButton_image()) &&
                Objects.equals(getButton_image_url(), that.getButton_image_url()) &&
                getSystem().equals(that.getSystem()) &&
                getSystem_id().equals(that.getSystem_id()) &&
                getResource_type().equals(that.getResource_type());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getResource_name(), getTarget_page(), getButton_image(), getButton_image_url(), getSystem(), getSystem_id(), getResource_type());
    }

    @Override
    public String toString() {
        return "STATICRESOURCES{" +
                "ID=" + ID +
                ", resource_name='" + resource_name + '\'' +
                ", target_page='" + target_page + '\'' +
                ", button_image='" + button_image + '\'' +
                ", button_image_url='" + button_image_url + '\'' +
                ", system=" + system +
                ", system_id=" + system_id +
                ", resource_type=" + resourceType +
                '}';
    }
}

