package Web.DAO.impl;

import Web.DAO.IIncident;
import Web.Entity.Incident;
import Web.Entity.User;
import Web.Init.Init;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

import static Web.Main.initDB;

public class IncidentDAO implements IIncident {

    public Incident save(Incident incident) {
        Session session = initDB.getSession();
        session.beginTransaction();
        session.save(incident);
        session.getTransaction().commit();
        session.close();
        return incident;
    }

    public Incident getById(int id) {
        Session session = initDB.getSession();
        session.beginTransaction();
        final Incident result = session.get(Incident.class, id);
        session.getTransaction().commit();
        session.close();
        return result != null ? result : new Incident();
    }

    public void update(Incident incident) {
        Session session = initDB.getSession();
        session.beginTransaction();
        session.update(incident);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Incident incident) {
        Session session = initDB.getSession();
        session.beginTransaction();
        session.delete(incident);
        session.getTransaction().commit();
        session.close();
    }

    public List<Incident> getAllIncident() {
        Session session = Init.getSession();
        session.beginTransaction();
        Query<Incident> query = session.createQuery(" FROM Incident");
        return query.list();
    }

    public List<Incident> fetchAllActiveIncidents() {
        Session session = Init.getSession();
        session.beginTransaction();
        Query<Incident> query = session.createQuery(" SELECT i FROM Incident i where i.isActive=:a");
        query.setParameter("a", true);
        return query.list();
    }
}
