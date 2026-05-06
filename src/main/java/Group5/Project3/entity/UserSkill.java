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

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "skill_id")
    private Long skill_id;

    @Column(name = "offered")
    private Boolean offered;

    public UserSkill() {
    }

    public UserSkill(Long userId, Long skillId, Boolean offered) {
        this.user_id = userId;
        this.skill_id = skillId;
        this.offered = offered;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return user_id;
    }

    public void setUserId(Long userId) {
        this.user_id = userId;
    }

    public Long getSkillId() {
        return skill_id;
    }

    public void setSkillId(Long skillId) {
        this.skill_id = skillId;
    }

    public Boolean getOffered() {
        return offered;
    }

    public void setOffered(Boolean offered) {
        this.offered = offered;
    }
}
