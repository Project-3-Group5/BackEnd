package Group5.Project3;
import Group5.Project3.controller.SkillController;
import Group5.Project3.entity.Skill;
import Group5.Project3.service.SkillService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
/**
 * Skill Controller Tests
 *
 * @author: Estrella Ortiz
 * @since: 5/6/2026
 * @version: 0.1.0
 */
@SpringBootTest
public class SkillControllerTests {
    @InjectMocks
    private SkillController skillController;

    @Mock
    private SkillService skillService;

    private Skill testSkill;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testSkill = new Skill("React", "Frontend framework", "Programming");
    }

    @Test
    void testGetAllSkills() {
        when(skillService.getAllSkills()).thenReturn(Arrays.asList(testSkill));

        List<Skill> result = skillController.getAllSkills();

        assertEquals(1, result.size());
        assertEquals("React", result.get(0).getName());
        verify(skillService, times(1)).getAllSkills();
    }

    @Test
    void testGetSkillById() {
        when(skillService.getSkillById(1)).thenReturn(testSkill);

        Skill result = skillController.getSkillById(1);

        assertEquals("React", result.getName());
        assertEquals("Frontend framework", result.getDescription());
        assertEquals("Programming", result.getCategory());
        verify(skillService, times(1)).getSkillById(1);
    }

    @Test
    void testDeleteSkill() {
        when(skillService.deleteSkill(1)).thenReturn(true);

        boolean result = skillController.deleteSkillById(1);

        assertTrue(result);
        verify(skillService, times(1)).deleteSkill(1);
    }
}
