package Web.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
@Getter
@Setter
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private int userRole;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "role_description")
    private String roleDescription;

    @OneToOne(mappedBy = "userRoleID", cascade = CascadeType.ALL)
    private User userID;
}
