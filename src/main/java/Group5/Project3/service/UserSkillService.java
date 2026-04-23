package Group5.Project3.service;

import Group5.Project3.entity.UserSkill;

import java.util.List;

/**
 * Interface for User Skill service
 *
 * @author: Dima Krayilo
 * @since: 4/22/2026
 * @version: 0.1.0
 *
 */
public interface UserSkillService {
    List<UserSkill> getUserSkills(Long userId);
    List<UserSkill> getOfferedSkills(Long userId);
    List<UserSkill> getDesiredSkills(Long userId);
    UserSkill addSkillToUser(Long userId, Long skillId, Boolean offered);
}
