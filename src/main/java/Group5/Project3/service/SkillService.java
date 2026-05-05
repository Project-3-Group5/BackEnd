package Group5.Project3.service;
import Group5.Project3.entity.Skill;
import java.util.List;

public interface SkillService {
    List<Skill> getAllSkills();
    Skill getSkillById(int id);
    Skill addSkill(Skill skill);
    Skill updateSkill(int id, Skill updatedSkill);
    boolean deleteSkill(int id);
}
