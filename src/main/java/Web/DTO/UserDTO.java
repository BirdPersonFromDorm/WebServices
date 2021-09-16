package Web.DTO;

import Web.DAO.impl.UserDAO;
import Web.Entity.User;

import java.util.List;

public class UserDTO {

    UserDAO userDAO = new UserDAO();

    public List<User> getAllUsers() {
        List<User> liftOfAllPatient = userDAO.getAllPatient();
        for (User user : liftOfAllPatient) {
            System.out.println("User: " + user.getUserName() + " Name: "
                    + user.getProfile().getFirsName() + " " + user.getProfile().getLastName());
        }

        return liftOfAllPatient;
    }
}
