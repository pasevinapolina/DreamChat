package by.bsu.dao;

import by.bsu.models.User;

import java.util.Collection;
import java.util.List;

/**
 * Created by user on 10.10.2015.
 */
public interface UserDao {
    void add(User user);

    void update(User user);

    void delete(User user);

    Collection<User> getUsers(String search);

    List<User> findByUser(String login, String password);
}
