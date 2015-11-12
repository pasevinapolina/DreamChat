package by.bsu.fpmi.pasevina.listenit.dao.impl;

import by.bsu.fpmi.pasevina.listenit.dao.UserDao;
import by.bsu.fpmi.pasevina.listenit.models.User;
import by.bsu.fpmi.pasevina.listenit.models.UserRole;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public User findById(String username) {
        return (User)getCurrentSession().get(User.class, username);
    }

    @Override
    public User save(User user) {
        getCurrentSession().save(user);
        getCurrentSession().flush();
        return user;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void addUserRole(User user, String role) {
        UserRole userRole = new UserRole(user, role);
        getCurrentSession().save(userRole);
        getCurrentSession().flush();
    }

    @Override
    public Collection<User> getUsers() {
        List users = getCurrentSession().createCriteria(User.class).list();
        Set<User> userSet = new HashSet<User>();
        for(Object obj : users) {
            userSet.add((User)obj);
        }
        return userSet;
    }

    @Override
    public Set<UserRole> gerUserRoles(String username) {
        Criteria criteria = getCurrentSession().createCriteria(UserRole.class);
        criteria.add(Restrictions.eq("user.username", username));
        List userRoles = criteria.list();
        Set<UserRole> userRoleSet = new HashSet<UserRole>();
        for(Object obj : userRoles) {
            userRoleSet.add((UserRole)obj);
        }
        return userRoleSet;
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
