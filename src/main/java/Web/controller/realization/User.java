package Web.controller.realization;

import Web.DAO.impl.*;
import Web.Entity.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static Web.controller.FunctionsOfUser.*;

public class User {

    public static void continuation(Web.Entity.User login) throws IOException {
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nПродолжить или выйти?\n" +
                "1. Продолжить \n" +
                "0. Выйти");
        String cont = bw.readLine();
        switch (cont) {
            case "1":
                usersFunctions(login);
            case "0":
                return;
        }
    }


    public static void usersFunctions(Web.Entity.User login) throws IOException {
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("\nWhat do you want to do:\n" +
                    "1. Subscribe Service \n" +
                    "2. Unsubscribe Service \n" +
                    "3. Create Incident  \n" +
                    "0. Exit");
            String move = bw.readLine();
            switch (move) {
                case "1":
                    int userIdFromLoginforService = login.getUserID();
                    BufferedReader forIdService = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter service Id");
                    int idService = Integer.parseInt(forIdService.readLine());
                    subscribeService(userIdFromLoginforService, idService);
                    continuation(login);
                    break;
                case "2":
                    BufferedReader serviceId = new BufferedReader(new InputStreamReader(System.in));
                    BufferedReader userId = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter User Id");
                    int userIDForSrvice = Integer.parseInt(serviceId.readLine());
                    System.out.println("Enter service ID");
                    int serviceIDForUser = Integer.parseInt(serviceId.readLine());
                    unsubscribeService(userIDForSrvice, serviceIDForUser);
                    continuation(login);
                    break;
                case "3":
                    int userIdFromLoginForIncident = login.getUserID();
                    BufferedReader forname = new BufferedReader(new InputStreamReader(System.in));
                    BufferedReader fordescription = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter name");
                    String name = forname.readLine();
                    System.out.println("Enter description");
                    String description = fordescription.readLine();
                    createIncident(userIdFromLoginForIncident, name, description);
                    continuation(login);
                    break;
                case "0":
                    break;
            }
            break;
        }
    }
}