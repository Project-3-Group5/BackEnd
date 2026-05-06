package Group5.Project3.controller;

import Group5.Project3.entity.User;
import Group5.Project3.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User Endpoints
 *
 * @author: Dima Krayilo
 * @since: 5/5/2026
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

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById((long) id).orElse(null);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser((long) id, user);
    }

    @PatchMapping("/{id}/bio")
    public User updateBio(@PathVariable Long id, @RequestBody String bio) {
        return userService.updateUserBio((long) id, bio);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable int id) {
        userService.deleteUser((long) id);
        return true;
    }
}
