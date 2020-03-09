package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import web.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("From User", User.class).list();
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void deleteUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

    @Override
    public User findUserById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public boolean ifUserExists(User user) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where username=:username");
        query.setParameter("username", user.getUsername());
        List<User> list = query.list();
        return list.size() == 0;
    }

    @Override
    public User findUserByName(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where username=:username");
        query.setParameter("username", username);
        return (User) query.uniqueResult();
    }
}
