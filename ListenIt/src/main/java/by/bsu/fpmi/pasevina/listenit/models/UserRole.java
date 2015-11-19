package by.bsu.fpmi.pasevina.listenit.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 */
@Entity
@Table(name = "user_role", uniqueConstraints = @UniqueConstraint(columnNames = {"ROLE", "username"}))

public class UserRole implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ROLE_ID")
    private  Long id;

    @Column(name = "ROLE")
    private String role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERNAME", nullable = false)
    private User user;

    public UserRole() {
    }

    public UserRole(User user, String role) {
        this.role = role;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
