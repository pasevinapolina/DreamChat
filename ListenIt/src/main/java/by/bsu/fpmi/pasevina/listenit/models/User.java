package by.bsu.fpmi.pasevina.listenit.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity class for User
 * @author Polina Pasevina
 * @version 1.0
 */
@Entity
@Table(name = "USER")
public class User implements Serializable {

    static final long serialVersionUID = 1L;
    @Id
    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    //private Set<UserRole> userRoles = new HashSet<UserRole>(0);

    public User() {

    }

    public User(String password, String username) {
        this.password = password;
        this.username = username;
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

    //public Set<UserRole> getUserRoles() {
    //    return userRoles;
    //}

    //public void setUserRoles(Set<UserRole> userRoles) {
    //    this.userRoles = userRoles;
    //}
}
