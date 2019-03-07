package tr.edu.tedu.anatomyweb.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public class USER {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long personId;

    private String name;
    private String user_name;
    private String password;
    private String email;

    public USER() {
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "USER{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        USER user = (USER) o;
        return personId == user.personId &&
                Objects.equals(name, user.name) &&
                Objects.equals(user_name, user.user_name) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, name, user_name, password, email);
    }
}
