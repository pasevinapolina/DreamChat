package by.bsu.fpmi.pasevina.listenit.services.impl;


import by.bsu.fpmi.pasevina.listenit.dao.UserDao;
import by.bsu.fpmi.pasevina.listenit.models.User;
import by.bsu.fpmi.pasevina.listenit.models.UserRole;
import by.bsu.fpmi.pasevina.listenit.services.UserService;
import by.bsu.fpmi.pasevina.listenit.utils.CustomPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Set;

/**
 *
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CustomPasswordEncoder passwordEncoder;

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User getUserById(String username) {
        return userDao.findById(username);
    }

    @Override
    public User registerNewAccount(User newUser) {
        if (usernameExists(newUser.getUsername())) {
            throw new NullPointerException("There is an account with that username: " + newUser.getUsername());
        }
        User user = new User();

        user.setUsername(newUser.getUsername());
        user.setPassword(passwordEncoder.encodePassword(newUser.getPassword(), newUser.getUsername()));
        //user.setFirstName(newUser.getFirstName());
        //user.setLastName(newUser.getLastName());
        user = userDao.save(user);
        userDao.addUserRole(user, "USER");
        return user;
    }

    @Override
    public Collection<User> getUsers(String search) {
        return userDao.getUsers();
    }

    @Override
    public Set<UserRole> getUserRolesById(String username) {
        return userDao.getUserRoles(username);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private boolean usernameExists(String username) {
        User user = userDao.findById(username);
        return user != null;
    }
}
