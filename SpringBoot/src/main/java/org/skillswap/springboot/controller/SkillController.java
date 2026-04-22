package org.skillswap.springboot.controller;

import org.skillswap.springboot.entity.Skill;
import org.skillswap.springboot.service.SkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillController {
    private SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }
    @GetMapping
    public List<Skill> getAllSkills(){
        return skillService.getAllSkills();
    }
    @GetMapping("/{id}")
    public Skill getSkillById(@PathVariable int id){
        return skillService.getSkillById(id);
    }
    @DeleteMapping("/{id}")
    public boolean deleteSkillById(@PathVariable int id){
        return skillService.deleteSkill(id);
    }


}
