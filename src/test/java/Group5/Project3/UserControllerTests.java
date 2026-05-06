package Group5.Project3;

import Group5.Project3.controller.UserController;
import Group5.Project3.entity.User;
import Group5.Project3.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

/**
 * [Brief Description]
 *
 * @author: Dima Krayilo
 * @since: 5/5/2026
 * @version: 0.1.0
 *
 */
@SpringBootTest
public class UserControllerTests {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private User testUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testUser = new User();
        testUser.setUsername("skill_trader");
        testUser.setBio("Expert in Java");
    }

    @Test
    void testGetAllUsers() {
        when(userService.getAllUsers()).thenReturn(Arrays.asList(testUser));

        List<User> result = userController.getAllUsers();

        assertEquals(1, result.size());
        assertEquals("skill_trader", result.get(0).getUsername());
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void testGetUserById() {
        when(userService.getUserById(1L)).thenReturn(Optional.of(testUser));

        User result = userController.getUserById(1L);

        assertEquals("skill_trader", result.getUsername());
        verify(userService, times(1)).getUserById(1L);
    }

    @Test
    void testDeleteUser() {
        // Your controller calls void deleteUser then returns true
        doNothing().when(userService).deleteUser(1L);

        boolean result = userController.deleteUser(1);

        assertTrue(result);
        verify(userService, times(1)).deleteUser(1L);
    }
}
