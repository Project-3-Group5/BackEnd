package Group5.Project3.service;

import Group5.Project3.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Interface for the User Service
 *
 * @author: Dima Krayilo
 * @since: 4/22/2026
 * @version: 0.1.0
 *
 */
public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    User updateUserBio(Long id, String bio);
    void deleteUser(Long id);
}
