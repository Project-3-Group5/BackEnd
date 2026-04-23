package Group5.Project3.entity;

import jakarta.persistence.*;

/**
 * User Skill entity table
 *
 * @author: Dima Krayilo
 * @since: 4/22/2026
 * @version: 0.1.0
 *
 */

@Entity
@Table(name = "user_skills")
public class UserSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @Column(name = "offered", nullable = false)
    private Boolean offered;

    public UserSkill() {
    }

    public UserSkill(User user, Skill skill, Boolean offered) {
        this.user = user;
        this.skill = skill;
        this.offered = offered;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Boolean getOffered() {
        return offered;
    }

    public void setOffered(Boolean offered) {
        this.offered = offered;
    }
}
