package Web.DAO.impl;

import Web.DAO.IService;
import Web.Entity.Incident;
import Web.Entity.Service;
import Web.Entity.User;
import Web.Init.Init;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

import static Web.Main.initDB;

public class ServiceDAO implements IService {

    public Service save(Service service) {
        Session session = initDB.getSession();
        session.beginTransaction();
        session.save(service);
        session.getTransaction().commit();
        session.close();
        return service;
    }

    public Service getById(int id) {
        Session session = initDB.getSession();
        session.beginTransaction();
        final Service result = session.get(Service.class, id);
        session.getTransaction().commit();
        session.close();
        return result != null ? result : new Service();
    }

    public void update(Service service) {
        Session session = initDB.getSession();
        session.beginTransaction();
        session.update(service);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Service service) {
        Session session = initDB.getSession();
        session.beginTransaction();
        session.delete(service);
        session.getTransaction().commit();
        session.close();
    }

}
