package Web.DAO;

import org.hibernate.Session;

import static Web.Main.initDB;

public interface IProfile {

    public Web.Entity.Profile save(Web.Entity.Profile profile);
    public Web.Entity.Profile getById(int id);
    public void update(Web.Entity.Profile profile);
    public void delete(Web.Entity.Profile profile);

}
