package Web.DAO.impl;

import Web.DAO.IUser;
import Web.Entity.User;
import org.hibernate.Session;

import static Web.Main.initDB;

public class UserDAO implements IUser {

    @Override
    public User save(User user) {
        Session session = initDB.getSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public User getById(int id) {
        Session session = initDB.getSession();
        session.beginTransaction();
        final User result = session.get(User.class, id);
        session.getTransaction().commit();
        session.close();
        return result != null ? result : new User();
    }

    public void update(User user) {
        Session session = initDB.getSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(User user) {
        Session session = initDB.getSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }
}
