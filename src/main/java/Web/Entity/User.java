package Web.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
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
    private UserRole userRole;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_id")
    private Profile profile;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Set<Service> services;
    @OneToMany(mappedBy = "users", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Incident> incidents;

}
