package Web.DAO;

import org.hibernate.Session;

import static Web.Main.initDB;

public interface IIncident {

    public Web.Entity.Incident save(Web.Entity.Incident incident);
    public Web.Entity.Incident getById(int id);
    public void update(Web.Entity.Incident incident);
    public void delete(Web.Entity.Incident incident);
}
