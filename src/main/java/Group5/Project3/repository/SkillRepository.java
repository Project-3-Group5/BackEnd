package Group5.Project3.repository;

import Group5.Project3.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Skill Repository
 *
 * @author: Dima Krayilo
 * @since: 4/22/2026
 * @version: 0.1.0
 *
 */
@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
}
