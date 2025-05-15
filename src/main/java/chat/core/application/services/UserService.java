package chat.core.application.services;

import chat.core.domain.entities.User;
import chat.core.domain.exception.UserNotFoundException;
import chat.core.domain.repositories.UserRepositoryMongo;
import chat.core.domain.services.IUserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepositoryMongo userRepository;

    @Autowired
    public UserService(UserRepositoryMongo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(String id, User user) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            throw new EntityNotFoundException("User not found with id: " + id);
        }

        User existingUser = userOptional.get();

        if (user.getName() != null) existingUser.setName(user.getName());
        if (user.getLogin() != null) existingUser.setLogin(user.getLogin());
        if (user.getPassword() != null) existingUser.setPassword(user.getPassword());

        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(String id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            throw new EntityNotFoundException("User not found with id: " + id);
        }

        userRepository.delete(userOptional.get());
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(String id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("User not found with id: " + id);
        }

        return userRepository.findById(id);
    }
}
