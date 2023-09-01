package dev.muneer.movies.Services;
import dev.muneer.movies.Models.User;
import dev.muneer.movies.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(User user) {
        return userRepository.insert(user);
    }

    public boolean validatePassword(User user, String password) {
        return user.getPassword().equals(password);
    }

}
