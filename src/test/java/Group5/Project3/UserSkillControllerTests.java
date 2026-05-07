package Group5.Project3;

import Group5.Project3.controller.UserSkillController;
import Group5.Project3.entity.UserSkill;
import Group5.Project3.service.UserSkillService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * [Brief Description]
 *
 * @author: Dima Krayilo
 * @since: 5/6/2026
 * @version: 0.1.0
 *
 */
@SpringBootTest
public class UserSkillControllerTests {

    @InjectMocks
    private UserSkillController userSkillController;

    @Mock
    private UserSkillService userSkillService;

    private UserSkill testUserSkill;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        // Using the flattened Long IDs we established
        testUserSkill = new UserSkill(1L, 10L, true);
    }

    @Test
    void testGetUserSkills() {
        when(userSkillService.getUserSkills(1L)).thenReturn(Arrays.asList(testUserSkill));

        // Controller takes int, casts to long for service
        List<UserSkill> result = userSkillController.getUserSkills(1);

        assertEquals(1, result.size());
        assertEquals(10L, result.get(0).getSkillId());
        verify(userSkillService, times(1)).getUserSkills(1L);
    }

    @Test
    void testGetOfferedSkills() {
        when(userSkillService.getOfferedSkills(1L)).thenReturn(Arrays.asList(testUserSkill));

        List<UserSkill> result = userSkillController.getOfferedSkills(1);

        assertNotNull(result);
        assertTrue(result.get(0).getOffered());
        verify(userSkillService, times(1)).getOfferedSkills(1L);
    }

    @Test
    void testGetDesiredSkills() {
        UserSkill desiredSkill = new UserSkill(1L, 20L, false);
        when(userSkillService.getDesiredSkills(1L)).thenReturn(Arrays.asList(desiredSkill));

        List<UserSkill> result = userSkillController.getDesiredSkills(1);

        assertNotNull(result);
        assertFalse(result.get(0).getOffered());
        verify(userSkillService, times(1)).getDesiredSkills(1L);
    }

    @Test
    void testAddSkillToUser() {
        when(userSkillService.addSkillToUser(1L, 10L, true)).thenReturn(testUserSkill);

        UserSkill result = userSkillController.addSkillToUser(1, 10, true);

        assertNotNull(result);
        assertEquals(1L, result.getUserId());
        assertEquals(10L, result.getSkillId());
        verify(userSkillService, times(1)).addSkillToUser(1L, 10L, true);
    }
}