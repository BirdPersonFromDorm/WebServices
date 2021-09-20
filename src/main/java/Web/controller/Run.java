package Web.controller;

import Web.DAO.impl.UserDAO;
import Web.Entity.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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


            List<User> allUser = userDAO.getAllUser();
            for (User user:allUser) {
                if (Objects.equals(login, user.getUserName()) && Objects.equals(password, user.getPassword())){
                    System.out.println("Welcome");
                    String userRole = user.getUserRole().getRoleName();
                    switch (userRole){
                        case "ADMIN":
                            break;
                        case "USER":
                            break;
                        case "SUPER_ADMIN":
                            SuperAdminFunctions.SuperAdminFunctions();
                        break;
                    }
                }
            }

            break;
        }
    }


}
