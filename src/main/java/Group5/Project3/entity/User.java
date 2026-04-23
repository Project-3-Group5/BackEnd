package Group5.Project3.entity;

import jakarta.persistence.*;

/**
 * User entity table
 *
 * @author: Dima Krayilo
 * @since: 4/22/2026
 * @version: 0.1.0
 *
 */

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "is_admin", nullable = false)
    private Boolean isAdmin;

    @Column(name = "bio")
    private String bio;

    public User() {
    }

    public User(String username, String password, Boolean isAdmin, String bio) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.bio = bio;
    }

    public Long getId() {
        return id;
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

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
