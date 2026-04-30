package Group5.Project3.controller;

import Group5.Project3.entity.User;
import Group5.Project3.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for the user endpoints
 *
 * @author: Dima Krayilo
 * @since: 4/30/2026
 * @version: 0.1.0
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
