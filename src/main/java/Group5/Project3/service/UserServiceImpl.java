package Group5.Project3.service;

import Group5.Project3.entity.User;
import Group5.Project3.repository.UserRepository;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of User Service
 *
 * @author: Dima Krayilo
 * @since: 4/29/2026
 * @version: 0.1.0
 *
 */
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User existing = userRepository.findById(id).orElseThrow();
        existing.setUsername(user.getUsername());
        existing.setAdmin(user.getAdmin());
        return userRepository.save(existing);
    }

    public User updateUserBio(Long id, String bio) {
        User existing = userRepository.findById(id).orElseThrow();
        existing.setBio(bio);
        return userRepository.save(existing);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
