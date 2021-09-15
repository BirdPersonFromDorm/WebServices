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

        Service byId1 = serviceDAO.getById(1);
        Service byId3 = serviceDAO.getById(2);

        User byId = userDAO.getById(2);

//        byId1.getUser().add(byId);
//        byId3.getUser().add(byId);

        byId.getService().add(byId1);
        byId.getService().add(byId3);

        System.out.println("up");
        userDAO.update(byId);

    }

    public static void AddNewUserAdmin(String name, String password){
        UserRole byId = userRoleDAO.getById(2);

        User user = new User();
        user.setUserName(name);
        user.setPassword(password);
        user.setUserRole(byId);

        userDAO.save(user);
    }
    public static void AddProfile(String firsName, String lastName, String email,
                                  String phoneNumber, String postalCode){
        Profile profile = new Profile();
        profile.setFirsName(firsName);
        profile.setLastName(lastName);
        profile.setEmail(email);
        profile.setPhoneNumber(phoneNumber);
        profile.setPostalCode(phoneNumber);

        profileDAO.save(profile);
    }
    public static void AddService(String name, boolean active, double price){

        Service service = new Service();
        service.setServiceName("Netflix");
        service.setActive(true);
        service.setServiceMonthPrice(10.5);

        serviceDAO.save(service);
    }
}
