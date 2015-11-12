package by.bsu.fpmi.pasevina.listenit.dao;



import by.bsu.fpmi.pasevina.listenit.models.User;
import by.bsu.fpmi.pasevina.listenit.models.UserRole;

import java.util.Collection;
import java.util.Set;

/**
 * Created by user on 10.10.2015.
 */
public interface UserDao {

    User findById(String username);
    User save(User user);
    void update(User user);
    void addUserRole(User user, String role);
    Collection<User> getUsers();
    Set<UserRole> gerUserRoles(String username);
}
