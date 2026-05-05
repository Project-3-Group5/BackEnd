package Group5.Project3.service;

import org.springframework.stereotype.Service;

import Group5.Project3.entity.Skill;
import Group5.Project3.repository.SkillRepository;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public Skill getSkillById(int id) {
        return skillRepository.findById((long) id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));
    }

    @Override
    public Skill addSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public Skill updateSkill(int id, Skill updatedSkill) {
        Skill existing = skillRepository.findById((long) id)
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        existing.setName(updatedSkill.getName());
        existing.setDescription(updatedSkill.getDescription());
        existing.setCategory(updatedSkill.getCategory());

        return skillRepository.save(existing);
    }

    @Override
    public boolean deleteSkill(int id) {
        if (!skillRepository.existsById((long) id)) {
            return false;
        }

        skillRepository.deleteById((long) id);
        return true;
    }
}
