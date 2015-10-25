package by.bsu.services;

import by.bsu.models.User;

import java.util.Collection;

/**
 *
 */
public interface UserService {

    Boolean add(User user);
    void update(User user);
    Collection<User> getUsers(String search);
    void delete(User user);
}
