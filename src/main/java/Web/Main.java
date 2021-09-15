package Web;

import Web.DAO.impl.*;
import Web.Entity.Profile;
import Web.Entity.Service;
import Web.Entity.User;
import Web.Entity.UserRole;
import Web.Init.Init;

import java.util.List;

public class Main {

    public static IncidentDAO incidentDAO = new IncidentDAO();
    public static ProfileDAO profileDAO = new ProfileDAO();
    public static ServiceDAO serviceDAO = new ServiceDAO();
    public static UserDAO userDAO = new UserDAO();
    public static UserRoleDAO userRoleDAO = new UserRoleDAO();

    public static final Init initDB = new Init();

    public static void main(String[] args) {


        User byId = userDAO.getById(13);
        Service byId1 = serviceDAO.getById(1);
        Service byId2 = serviceDAO.getById(2);

        byId.getService().add(byId1);
        byId.getService().add(byId2);

        byId1.getUser().add(byId);
        byId2.getUser().add(byId);

        userDAO.update(byId);

    }

    public static void AddNewUserAdmin(String name, String password){
        UserRole byId = userRoleDAO.getById(1);

        User user = new User();
        user.setUserName(name);
        user.setPassword(password);
        user.setUserRoleID(byId);

        userDAO.save(user);
    }
}
