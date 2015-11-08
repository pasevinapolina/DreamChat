package by.bsu.dao;

import by.bsu.models.User;
import by.bsu.models.UserRole;

import java.util.Collection;
import java.util.List;
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
