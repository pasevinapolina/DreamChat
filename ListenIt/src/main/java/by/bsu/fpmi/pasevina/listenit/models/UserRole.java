package by.bsu.fpmi.pasevina.listenit.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 */
@Entity
@Table(name = "USER_ROLE", uniqueConstraints = @UniqueConstraint(columnNames = {"ROLE", "USERNAME"}))

public class UserRole implements Serializable{

    static final long serialVersionUID = 1L;

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
