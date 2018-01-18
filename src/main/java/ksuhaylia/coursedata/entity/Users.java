package ksuhaylia.coursedata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.access.method.P;

import javax.persistence.*;
import java.util.List;


@Entity
public class Users {
    private int userId;
    @NotEmpty(message = "name is required!")
    private String userName;
    private String userLastName;
    @NotEmpty(message = "password is required!")
    private String password;
    @NotEmpty(message = "eMail is required!")
    @Email(message = "Incorrect eMail!")
    private String email;
    private Boolean login;
    private Boolean biolog;
    private Boolean geolog;
    private Boolean antropolog;
    private Boolean minerolog;
    private Boolean banned;
    private Boolean admin;
    private List<Posts> posts;

    protected Users()
    {}

    public Users(String name, String lastname, String email, String password)
    {
        this.userName = name;
        this.userLastName = lastname;
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 255)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_last_name", nullable = false, length = 255)
    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 25)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public List<Posts> getPosts() {return posts;}

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (userId != users.userId) return false;
        if (userName != null ? !userName.equals(users.userName) : users.userName != null) return false;
        if (userLastName != null ? !userLastName.equals(users.userLastName) : users.userLastName != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userLastName != null ? userLastName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "login", nullable = true)
    public Boolean getLogin() {
        return login;
    }

    public void setLogin(Boolean login) {
        this.login = login;
    }

    @Basic
    @Column(name = "biolog", nullable = true)
    public Boolean getBiolog() {
        return biolog;
    }

    public void setBiolog(Boolean biolog) {
        this.biolog = biolog;
    }

    @Basic
    @Column(name = "geolog", nullable = true)
    public Boolean getGeolog() {
        return geolog;
    }

    public void setGeolog(Boolean geolog) {
        this.geolog = geolog;
    }

    @Basic
    @Column(name = "antropolog", nullable = true)
    public Boolean getAntropolog() {
        return antropolog;
    }

    public void setAntropolog(Boolean antropolog) {
        this.antropolog = antropolog;
    }

    @Basic
    @Column(name = "minerolog", nullable = true)
    public Boolean getMinerolog() {
        return minerolog;
    }

    public void setMinerolog(Boolean minerolog) {
        this.minerolog = minerolog;
    }

    @Basic
    @Column(name = "banned", nullable = true)
    public Boolean getBanned() {
        return banned;
    }

    public void setBanned(Boolean banned) {
        this.banned = banned;
    }

    @Basic
    @Column(name = "admin")
    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

}
