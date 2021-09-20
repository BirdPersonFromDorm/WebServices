package Web.DTO;

import Web.DAO.impl.UserDAO;
import Web.Entity.User;
import Web.Entity.UserRole;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
public class UserDTO {


    private String userName;
    private String role;

    public UserDTO mapToDTO(User user, UserRole userRole){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(user.getUserName());
        userDTO.setRole(userRole.getRoleName());

        return userDTO;
    }

}
