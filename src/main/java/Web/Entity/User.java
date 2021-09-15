package Web.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_id")
    private int userID;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_role_id")
    private UserRole userRoleID;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_id")
    private Profile profile;
    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private List<Service> service;


//    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<Incident> incident;

//    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<Service> service;

}
