package Web.DAO;

import org.hibernate.Session;

import static Web.Main.initDB;

public interface IService {

    public Web.Entity.Service save(Web.Entity.Service service);
    public Web.Entity.Service getById(int id);
    public void update(Web.Entity.Service service);
    public void delete(Web.Entity.Service service);

}
