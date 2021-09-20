package Web;

import Web.DAO.impl.*;
import Web.DTO.UserDTO;
import Web.Entity.*;
import Web.Init.Init;
import Web.controller.Run;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static IncidentDAO incidentDAO = new IncidentDAO();
    public static ProfileDAO profileDAO = new ProfileDAO();
    public static ServiceDAO serviceDAO = new ServiceDAO();
    public static UserDAO userDAO = new UserDAO();
    public static UserRoleDAO userRoleDAO = new UserRoleDAO();


    public static final Init initDB = new Init();

    public static void main(String[] args) throws IOException {
//          Don't touch this
//        User userByid1 = userDAO.getById(1);
//
//        UserRole userRole = userRoleDAO.getById(userByid1.getUserRole().getUserRole());
//
//        UserDTO userDTO = new UserDTO();
//        userDTO = userDTO.mapToDTO(userByid1,userRole);
//
//        System.out.println(userDTO);

        // For test (don't work)
        User user = userDAO.getById(1);
        Service service = serviceDAO.getById(2);

        user.getService().remove(service);
        service.getUser().remove(user);

        userDAO.update(user);
        serviceDAO.update(service);


        //Run.run();
    }

    //      Personal methods
    public static void unsubscribeService(int idUser, int idService){
        User userByID = userDAO.getById(idUser);
        Service serviceByID = serviceDAO.getById(idService);

        userDAO.delete(userByID);
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
