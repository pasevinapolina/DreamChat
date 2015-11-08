package by.bsu.services;

import by.bsu.models.User;
import by.bsu.models.UserRole;

import java.util.Collection;
import java.util.Set;

/**
 *
 */
public interface UserService {

    void update(User user);
    User getUserById(String username);
    User registerNewAccount(User newUser) throws Exception;
    Collection<User> getUsers(String search);
    Set<UserRole> getUserRolesById(String username);
}
