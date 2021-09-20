package Web.controller;

import Web.DAO.impl.*;
import Web.Entity.Incident;
import Web.Entity.Service;
import Web.Entity.User;
import Web.Entity.UserRole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class SuperAdminFunctions {

    public static IncidentDAO incidentDAO = new IncidentDAO();
    public static ProfileDAO profileDAO = new ProfileDAO();
    public static ServiceDAO serviceDAO = new ServiceDAO();
    public static UserDAO userDAO = new UserDAO();
    public static UserRoleDAO userRoleDAO = new UserRoleDAO();

    public static void continuous() throws IOException {
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nПродолжить или выйти?\n" +
                "1. Продолжить \n" +
                "0. Выйти");
        String cont = bw.readLine();
        switch (cont) {
            case "1":
                SuperAdminFunctions();
            case "0":
                return;
        }
    }


    public static void SuperAdminFunctions() throws IOException {
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("\nWhat do you want to do:\n" +
                    "1. Get all Users \n" +
                    "2. Get all incidents \n" +
                    "3. Get all active incidents \n" +
                    "4. Get user by id \n" +
                    "5. Add user \n" +
                    "6. Subscribe Service \n" +
                    "7. Create Incident \n" +
                    "8. Close Incident \n" +
                    "9. Delete user by id \n" +
                    "0. Exit");
            String move = bw.readLine();
            switch (move) {
                case "1":
                    List<User> allUser = userDAO.getAllUser();
                    for (User user : allUser) {
                        System.out.println(user.getUserName());
                    }
                    continuous();
                    break;
                case "2":
                    List<Incident> incidents = incidentDAO.getAllIncident();
                    for (Incident incident : incidents) {
                        System.out.println("Name: " + incident.getServiceName() + " Description: " + incident.getProblemDescription());
                    }
                    continuous();
                    break;
                case "3":
                    List<Incident> activeIncident = incidentDAO.fetchAllActiveIncidents();
                    for (Incident incident : activeIncident) {
                        System.out.println("Name: " + incident.getServiceName() + " Description: " + incident.getProblemDescription());
                    }
                    continuous();
                    break;
                case "4":
                    BufferedReader userbuId = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("enter id");
                    int userByID = Integer.parseInt(userbuId.readLine());
                    getUserByID(userByID);
                    continuous();
                    break;
                case "5":
                    BufferedReader forLogin = new BufferedReader(new InputStreamReader(System.in));
                    BufferedReader forPasswrod = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter login");
                    String login = forLogin.readLine();
                    System.out.println("Enter passwod");
                    String passwod = forPasswrod.readLine();
                    AddNewUser(login, passwod);
                    System.out.println("You added new User");
                    continuous();
                    break;
                case "6":
                    BufferedReader foridUser = new BufferedReader(new InputStreamReader(System.in));
                    BufferedReader foridService = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter id User");
                    int idUser = Integer.parseInt(foridUser.readLine());
                    System.out.println("Enter id User");
                    int idService = Integer.parseInt(foridService.readLine());
                    subscribeService(idUser, idService);
                    break;
                case "7":
                    BufferedReader forUserID = new BufferedReader(new InputStreamReader(System.in));
                    BufferedReader forname = new BufferedReader(new InputStreamReader(System.in));
                    BufferedReader fordescription = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter id User");
                    int userID = Integer.parseInt(forUserID.readLine());
                    System.out.println("Enter name");
                    String name = forname.readLine();
                    System.out.println("Enter description");
                    String description = fordescription.readLine();

                    createIncident(userID, name, description);
                    break;
                case "8":
                    BufferedReader forincidentID = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter id User");
                    int incidentID = Integer.parseInt(forincidentID.readLine());
                    closeIncident(incidentID);
                    break;
                case "9":
                    BufferedReader foruserID = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter id User");
                    int userIDToDelete = Integer.parseInt(foruserID.readLine());
                    deleteUserByID(userIDToDelete);
                    break;
                case "0":
                    break;

            }
            break;
        }

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

        userByID.getService().add(serviceByID);
        serviceByID.getUser().add(userByID);

        serviceDAO.update(serviceByID);
    }

    public static void createIncident(int userID, String name, String description) {
        User userByID = userDAO.getById(userID);

        Incident incident = new Incident();
        incident.setServiceName("Some Name of Incident");
        incident.setActive(true);
        incident.setProblemDescription("Some problem with something");
        incident.setUser(userByID);

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
