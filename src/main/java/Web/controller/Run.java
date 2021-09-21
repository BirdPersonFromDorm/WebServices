package Web.controller;

import Web.DAO.impl.UserDAO;
import Web.controller.realization.Admin;
import Web.controller.realization.SuperAdmin;
import Web.controller.realization.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;


public class Run {

    public static UserDAO userDAO = new UserDAO();

    public static void run() throws IOException {
        while(true){
            BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter your login");
            String login = bw.readLine();
            System.out.println("Enter your login");
            String password = bw.readLine();


            List<Web.Entity.User> allUser = userDAO.getAllUser();
            for (Web.Entity.User user:allUser) {
                if (Objects.equals(login, user.getUserName()) && Objects.equals(password, user.getPassword())){
                    Web.Entity.User loggedUser = user;
                    System.out.println("Welcome");
                    String userRole = user.getUserRole().getRoleName();
                    switch (userRole){
                        case "ADMIN":
                            Admin.adminFunctions();
                            break;
                        case "USER":
                            User.usersFunctions(loggedUser);
                            break;
                        case "SUPER_ADMIN":
                            SuperAdmin.SuperAdminFunctions();
                        break;
                    }
                }
            }
            break;
        }
    }
}
