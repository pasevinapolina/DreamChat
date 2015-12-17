package by.bsu.fpmi.pasevina.listenit.models;

import by.bsu.fpmi.pasevina.listenit.handlers.PasswordMatches;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity class for User
 * @author Polina Pasevina
 * @version 1.0
 */
@PasswordMatches
@Entity
@Table(name = "USER")
public class User implements Serializable {

    static final long serialVersionUID = 1L;
    @Id
    @Column(name = "USERNAME", nullable = false)
    @NotNull
    private String username;

    @NotNull
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Transient
    private String matchingPassword;

    @Enumerated(EnumType.STRING)
    @Column(name = "SOCIAL_PROVIDER", length = 20)
    private SocialMediaService signInProvider;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Audio> userAudios = new HashSet<Audio>();

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

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public SocialMediaService getSignInProvider() {
        return signInProvider;
    }

    public void setSignInProvider(SocialMediaService signInProvider) {
        this.signInProvider = signInProvider;
    }

    public Set<Audio> getUserAudios() {
        return userAudios;
    }

    public void setUserAudios(Set<Audio> userAudios) {
        this.userAudios = userAudios;
    }

    //public Set<UserRole> getUserRoles() {
    //    return userRoles;
    //}

    //public void setUserRoles(Set<UserRole> userRoles) {
    //    this.userRoles = userRoles;
    //}
}
