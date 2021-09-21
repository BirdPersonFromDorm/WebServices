package Web.controller.realization;

import Web.DAO.impl.*;
import Web.Entity.*;
import Web.controller.FunctionsOfAdmin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static Web.controller.FunctionsOfAdmin.*;

public class Admin{

    public static IncidentDAO incidentDAO = new IncidentDAO();
    public static ProfileDAO profileDAO = new ProfileDAO();
    public static ServiceDAO serviceDAO = new ServiceDAO();
    public static UserDAO userDAO = new UserDAO();
    public static UserRoleDAO userRoleDAO = new UserRoleDAO();


    public static void continuation() throws IOException {
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nПродолжить или выйти?\n" +
                "1. Продолжить \n" +
                "0. Выйти");
        String cont = bw.readLine();
        switch (cont) {
            case "1":
                adminFunctions();
            case "0":
                return;
        }
    }
    public static void adminFunctions() throws IOException {
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
                    "10. Unsubscribe Service \n" +
                    "11. Update user \n" +
                    "0. Exit");
            String move = bw.readLine();
            switch (move) {
                case "1":
                    List<Web.Entity.User> allUser = userDAO.getAllUser();
                    for (Web.Entity.User user : allUser) {
                        System.out.println(user.getUserName());
                    }
                    continuation();
                    break;
                case "2":
                    List<Incident> incidents = incidentDAO.getAllIncident();
                    for (Incident incident : incidents) {
                        System.out.println("Name: " + incident.getServiceName() + " Description: " + incident.getProblemDescription());
                    }
                    continuation();
                    break;
                case "3":
                    List<Incident> activeIncident = incidentDAO.fetchAllActiveIncidents();
                    for (Incident incident : activeIncident) {
                        System.out.println("Name: " + incident.getServiceName() + " \nDescription: " + incident.getProblemDescription());
                    }
                    continuation();
                    break;
                case "4":
                    BufferedReader userbuId = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("enter id");
                    int userByID = Integer.parseInt(userbuId.readLine());
                    getUserByID(userByID);
                    continuation();
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
                    continuation();
                    break;
                case "6":
                    BufferedReader foridUser = new BufferedReader(new InputStreamReader(System.in));
                    BufferedReader foridService = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter id User");
                    int idUser = Integer.parseInt(foridUser.readLine());
                    System.out.println("Enter id User");
                    int idService = Integer.parseInt(foridService.readLine());
                    subscribeService(idUser, idService);
                    continuation();
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
                    continuation();
                    break;
                case "8":
                    BufferedReader forincidentID = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter id User");
                    int incidentID = Integer.parseInt(forincidentID.readLine());
                    closeIncident(incidentID);
                    continuation();
                    break;
                case "9":
                    BufferedReader foruserID = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter id User");
                    int userIDToDelete = Integer.parseInt(foruserID.readLine());
                    deleteUserByID(userIDToDelete);
                    continuation();
                    break;
                case "10":
                    BufferedReader serviceId = new BufferedReader(new InputStreamReader(System.in));
                    BufferedReader userId = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter User Id");
                    int userIDForSrvice = Integer.parseInt(serviceId.readLine());
                    System.out.println("Enter service ID");
                    int serviceIDForUser = Integer.parseInt(serviceId.readLine());
                    unsubscribeService(userIDForSrvice, serviceIDForUser);
                    continuation();
                    break;
                case "11":
                    System.out.println("what do you want to update?\n" +
                            "login\n" +
                            "password\n" +
                            "name\n" +
                            "lastname\n" +
                            "back\n");
                    BufferedReader lineForUpdate = new BufferedReader(new InputStreamReader(System.in));
                    String updateLine = lineForUpdate.readLine();
                    switch (updateLine) {
                        case "login":
                            System.out.println("Enter user id");
                            BufferedReader IdOfUserForUpdateLogin = new BufferedReader(new InputStreamReader(System.in));
                            int useridForUpdate = Integer.parseInt(IdOfUserForUpdateLogin.readLine());

                            System.out.println("Enter new Login");
                            BufferedReader newLoginOfUser = new BufferedReader(new InputStreamReader(System.in));
                            String newLogin = newLoginOfUser.readLine();

                            updateLogin(useridForUpdate, newLogin);
                            break;
                        case "password":
                            System.out.println("Enter user id");
                            BufferedReader IdOfUserForUpdatePassword = new BufferedReader(new InputStreamReader(System.in));
                            int useridForUpdatePassword = Integer.parseInt(IdOfUserForUpdatePassword.readLine());

                            System.out.println("Enter new password");
                            BufferedReader newPasswrodOfUser = new BufferedReader(new InputStreamReader(System.in));
                            String newPassword = newPasswrodOfUser.readLine();

                            updatePassword(useridForUpdatePassword, newPassword);
                            break;
                        case "name":
                            System.out.println("Enter user Id");
                            BufferedReader IdOfUserForUpdateName = new BufferedReader(new InputStreamReader(System.in));
                            int useridForUpdateName = Integer.parseInt(IdOfUserForUpdateName.readLine());

                            System.out.println("Enter new Name");
                            BufferedReader newNameOfUser = new BufferedReader(new InputStreamReader(System.in));
                            String newName = newNameOfUser.readLine();

                            updateName(useridForUpdateName, newName);
                            break;
                        case "lastname":
                            System.out.println("Enter new Id");
                            BufferedReader IdOfUserForUpdateLastName = new BufferedReader(new InputStreamReader(System.in));
                            int useridForUpdateLastName = Integer.parseInt(IdOfUserForUpdateLastName.readLine());

                            System.out.println("Enter new Lastname");
                            BufferedReader newLastnameOfUser = new BufferedReader(new InputStreamReader(System.in));
                            String newLastname = newLastnameOfUser.readLine();

                            updateLastname(useridForUpdateLastName, newLastname);
                            break;
                        case "back":
                            break;
                    }
                    continuation();
                    break;
                case "0":
                    break;
            }
            break;
        }
    }
}
