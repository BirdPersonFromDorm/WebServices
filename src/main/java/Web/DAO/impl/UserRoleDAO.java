package Web.DAO.impl;

import Web.DAO.IUserRole;
import Web.Entity.UserRole;
import Web.Init.Init;
import org.hibernate.Session;

//import static Web.Main.initDB;

public class UserRoleDAO implements IUserRole {

    public UserRole save(UserRole userRole) {
        Session session = Init.getSession();
        session.beginTransaction();
        session.save(userRole);
        session.getTransaction().commit();
        session.close();
        return userRole;
    }

    public UserRole getById(int id) {
        Session session = Init.getSession();
        session.beginTransaction();
        final UserRole result = session.get(UserRole.class, id);
        session.getTransaction().commit();
        session.close();
        return result != null ? result : new UserRole();
    }

    public void update(UserRole userRole) {
        Session session = Init.getSession();
        session.beginTransaction();
        session.update(userRole);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(UserRole userRole) {
        Session session = Init.getSession();
        session.beginTransaction();
        session.delete(userRole);
        session.getTransaction().commit();
        session.close();
    }

}
