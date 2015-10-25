package by.bsu.services.impl;

import by.bsu.dao.UserDao;
import by.bsu.models.User;
import by.bsu.services.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 *
 */
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public Boolean add(User user) {
        List<User> duplicate = userDao.findByUser(user.getLogin(), user.getPassword());
        if(duplicate.isEmpty()) {
            userDao.add(user);
            return true;
        }
        return false;
    }

    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Transactional
    public Collection<User> getUsers(String search) {
        return userDao.getUsers(search);
    }

    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }
}
