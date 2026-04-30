package Group5.Project3.service;

import Group5.Project3.entity.Skill;
import Group5.Project3.entity.User;
import Group5.Project3.entity.UserSkill;
import Group5.Project3.repository.SkillRepository;
import Group5.Project3.repository.UserRepository;
import Group5.Project3.repository.UserSkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation for UserSkills Service
 *
 * @author: Dima Krayilo
 * @since: 4/29/2026
 * @version: 0.1.0
 *
 */
@Service
public class UserSkillServiceImpl implements UserSkillService{
    private final UserSkillRepository userSkillRepository;
    private final UserRepository userRepository;
    private final SkillRepository skillRepository;

    public UserSkillServiceImpl(UserSkillRepository userSkillRepository,
                                UserRepository userRepository,
                                SkillRepository skillRepository) {
        this.userSkillRepository = userSkillRepository;
        this.userRepository = userRepository;
        this.skillRepository = skillRepository;
    }

    public List<UserSkill> getUserSkills(Long userId) {
        return userSkillRepository.findByUserId(userId);
    }

    public List<UserSkill> getOfferedSkills(Long userId) {
        return userSkillRepository.findByUserIdAndOffered(userId, true);
    }

    public List<UserSkill> getDesiredSkills(Long userId) {
        return userSkillRepository.findByUserIdAndOffered(userId, false);
    }

    public UserSkill addSkillToUser(Long userId, Long skillId, Boolean offered) {
        User user = userRepository.findById(userId).orElseThrow();
        Skill skill = skillRepository.findById(skillId).orElseThrow();

        UserSkill userSkill = new UserSkill(user, skill, offered);
        return userSkillRepository.save(userSkill);
    }
}
