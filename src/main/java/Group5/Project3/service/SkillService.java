package Group5.Project3.service;

import Group5.Project3.entity.Skill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {
    public List<Skill> getAllSkills(){
        return null;
    }
    public Skill getSkillById(int id){
        return null;
    }
    public Skill updateSkill(int id,Skill updatedSkill){
        return updatedSkill;
    }
    public Skill addSkill(Skill skill){
        return skill;
    }
    public boolean deleteSkill(int id){
        return true;
    }

}
