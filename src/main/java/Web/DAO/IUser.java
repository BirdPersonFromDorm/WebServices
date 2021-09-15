package Web.DAO;

import org.hibernate.Session;

import static Web.Main.initDB;

public interface IUser {

    public Web.Entity.User save(Web.Entity.User user);
    public Web.Entity.User getById(int id);
    public void update(Web.Entity.User user);
    public void delete(Web.Entity.User user);

}
