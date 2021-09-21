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

        Run.run();
    }
}
