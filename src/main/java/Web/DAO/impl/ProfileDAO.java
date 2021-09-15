package Web.DAO.impl;

import Web.DAO.IProfile;
import Web.Entity.Profile;
import org.hibernate.Session;

import static Web.Main.initDB;

public class ProfileDAO implements IProfile {

    public Profile save(Profile profile) {
        Session session = initDB.getSession();
        session.beginTransaction();
        session.save(profile);
        session.getTransaction().commit();
        session.close();
        return profile;
    }

    public Profile getById(int id) {
        Session session = initDB.getSession();
        session.beginTransaction();
        final Profile result = session.get(Profile.class, id);
        session.getTransaction().commit();
        session.close();
        return result != null ? result : new Profile();
    }

    public void update(Profile profile) {
        Session session = initDB.getSession();
        session.beginTransaction();
        session.update(profile);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Profile profile) {
        Session session = initDB.getSession();
        session.beginTransaction();
        session.delete(profile);
        session.getTransaction().commit();
        session.close();
    }

}
