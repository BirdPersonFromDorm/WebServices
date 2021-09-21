package Web.DAO.impl;

import Web.DAO.IUser;
import Web.Entity.User;
import Web.Init.Init;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.net.ssl.HandshakeCompletedEvent;
import java.util.List;

//import static Web.Main.initDB;

public class UserDAO implements IUser {

    @Override
    public User save(User user) {
        Session session = Init.getSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }
    @Override
    public User getById(int id) {
        Session session = Init.getSession();
        session.beginTransaction();
        final User result = session.get(User.class, id);
        session.getTransaction().commit();
        session.close();
        return result != null ? result : new User();
    }
    @Override
    public void update(User user) {
        Session session = Init.getSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    public void delete(User user) {
        Session session = Init.getSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }
    public List<User> getAllUser() {
        Session session = Init.getSession();
        session.beginTransaction();
        Query<User> query = session.createQuery(" FROM User");
        return query.list();
    }

}
