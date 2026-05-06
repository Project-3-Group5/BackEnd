package Group5.Project3.controller;

import Group5.Project3.entity.UserSkill;
import Group5.Project3.service.UserSkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User Skill Controller for the endpoints
 *
 * @author: Dima Krayilo
 * @since: 5/5/2026
 * @version: 0.1.0
 *
 */
@RestController
@RequestMapping("/user-skill")
public class UserSkillController {

    private final UserSkillService userSkillService;

    public UserSkillController(UserSkillService userSkillService) {
        this.userSkillService = userSkillService;
    }

    @GetMapping("/user/{userId}")
    public List<UserSkill> getUserSkills(@PathVariable int userId) {
        return userSkillService.getUserSkills((long) userId);
    }

    @GetMapping("/user/{userId}/offered")
    public List<UserSkill> getOfferedSkills(@PathVariable int userId) {
        return userSkillService.getOfferedSkills((long) userId);
    }

    @GetMapping("/user/{userId}/desired")
    public List<UserSkill> getDesiredSkills(@PathVariable int userId) {
        return userSkillService.getDesiredSkills((long) userId);
    }

    @PostMapping("/add")
    public UserSkill addSkillToUser(
            @RequestParam int userId,
            @RequestParam int skillId,
            @RequestParam Boolean offered) {
        return userSkillService.addSkillToUser((long) userId, (long) skillId, offered);
    }
}
