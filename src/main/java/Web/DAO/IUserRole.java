package Web.DAO;

import org.hibernate.Session;

import static Web.Main.initDB;

public interface IUserRole {

    public Web.Entity.UserRole save(Web.Entity.UserRole userRole);
    public Web.Entity.UserRole getById(int id);
    public void update(Web.Entity.UserRole userRole);
    public void delete(Web.Entity.UserRole userRole);

}
