package Web.controller;

import Web.DAO.impl.*;
import Web.Entity.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FunctionsOfAdmin {

    public static IncidentDAO incidentDAO = new IncidentDAO();
    public static ProfileDAO profileDAO = new ProfileDAO();
    public static ServiceDAO serviceDAO = new ServiceDAO();
    public static UserDAO userDAO = new UserDAO();
    public static UserRoleDAO userRoleDAO = new UserRoleDAO();

    public static void updateLastname(int userId, String lastname) {
        User userByID = userDAO.getById(userId);

        Profile profile = profileDAO.getById(userByID.getUserID());
        profile.setLastName(lastname);

        profileDAO.update(profile);
    }

    public static void updateName(int userId, String name) {
        User userByID = userDAO.getById(userId);

        Profile profile = profileDAO.getById(userByID.getUserID());
        profile.setFirsName(name);

        profileDAO.update(profile);
    }

    public static void updatePassword(int userId, String password) {
        User userByID = userDAO.getById(userId);
        userByID.setPassword(password);
        userDAO.update(userByID);
    }

    public static void updateLogin(int userId, String login) {
        User userByID = userDAO.getById(userId);
        userByID.setUserName(login);
        userDAO.update(userByID);
    }

    public static void unsubscribeService(int userId, int serviceId) {
        User user = userDAO.getById(2);
        Service service = serviceDAO.getById(2);

        user.getServices().remove(user.getServices().stream().findFirst().get());
        service.getUsers().remove(service.getUsers().stream().findFirst().get());

        userDAO.update(user);
        serviceDAO.update(service);
    }

    public static void getUserByID(int id) {
        User userByID = userDAO.getById(id);
        System.out.println(userByID.getUserName());
    }

    public static void AddNewUser(String name, String password) {
        UserRole byId = userRoleDAO.getById(1);

        User user = new User();
        user.setUserName(name);
        user.setPassword(password);
        user.setUserRole(byId);

        userDAO.save(user);
    }

    public static void subscribeService(int idUser, int idService) {
        User userByID = userDAO.getById(idUser);
        Service serviceByID = serviceDAO.getById(idService);

        userByID.getServices().add(serviceByID);
        serviceByID.getUsers().add(userByID);

        serviceDAO.update(serviceByID);
    }

    public static void createIncident(int userID, String name, String description) {
        User userByID = userDAO.getById(userID);

        Incident incident = new Incident();
        incident.setServiceName("Some Name of Incident");
        incident.setActive(true);
        incident.setProblemDescription("Some problem with something");
        incident.setUsers(userByID);

        incidentDAO.save(incident);
    }

    public static void closeIncident(int IncidentID) {
        Incident incidentByID = incidentDAO.getById(IncidentID);

        incidentByID.setActive(false);

        incidentDAO.update(incidentByID);
    }

    public static void deleteUserByID(int userID) {
        User UserByID = userDAO.getById(userID);
        userDAO.delete(UserByID);
    }
}
