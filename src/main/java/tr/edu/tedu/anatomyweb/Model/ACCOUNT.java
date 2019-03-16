package tr.edu.tedu.anatomyweb.Model;


import tr.edu.tedu.anatomyweb.Utils.UserRole;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT")
public class ACCOUNT {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    private String username;
    private String password;
    private String mail;
    private String name;
    private UserRole userRole;
    private String phone_number;
    private String gender;

    public ACCOUNT() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ACCOUNT account = (ACCOUNT) o;
        return Objects.equals(ID, account.ID) &&
                Objects.equals(username, account.username) &&
                Objects.equals(password, account.password) &&
                Objects.equals(mail, account.mail) &&
                Objects.equals(name, account.name) &&
                userRole == account.userRole &&
                Objects.equals(phone_number, account.phone_number) &&
                Objects.equals(gender, account.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, username, password, mail, name, userRole, phone_number, gender);
    }

    @Override
    public String toString() {
        return "ACCOUNT{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", name='" + name + '\'' +
                ", userRole=" + userRole +
                ", phone_number='" + phone_number + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
