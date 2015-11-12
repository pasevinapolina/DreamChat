package by.bsu.fpmi.pasevina.listenit.services;



import by.bsu.fpmi.pasevina.listenit.models.User;
import by.bsu.fpmi.pasevina.listenit.models.UserRole;

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
