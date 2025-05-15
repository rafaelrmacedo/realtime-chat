package chat.core.domain.services;

import chat.core.domain.entities.User;
import chat.core.domain.exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User createUser(User user);
    User updateUser(String id, User user) throws UserNotFoundException;
    void deleteUser(String id);
    List<User> getUsers();
    Optional<User> getUser(String id);
}
