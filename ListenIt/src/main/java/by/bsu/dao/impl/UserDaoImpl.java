package by.bsu.dao.impl;

import by.bsu.dao.UserDao;
import by.bsu.models.User;
import by.bsu.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

/**
 *
 */
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    //private EntityManager entityManager;

    Session session = HibernateUtil.getSessionFactory().openSession();

    public void add(User user) {
        //entityManager.persist(user);
    }

    public void update(User user) {
        //entityManager.merge(user);

    }

    public void delete(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            User user =
                   (User)session.get(User.class, id);
            session.delete(user);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public Collection<User> getUsers(String search) {

        /*if(search == null || search.trim().isEmpty()) {
            return entityManager.createQuery(
                    "select u from User u").getResultList();
        }
        return entityManager.createQuery(
                "select u from User u where u like :search")
                .setParameter("search", search.trim() + "%")
                .getResultList();
                */

    }

    public List<User> findByUser(String login, String password) {


         return new List<User>(0);/*entityManager.createQuery(
                 "select u from User where u.login = :login and u.password = :password")
                 .setParameter("login", login)
                 .setParameter("password", password)
                 .getResultList();
*/
    }
}
