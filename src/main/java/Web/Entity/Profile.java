package Web.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "profile")
@Getter
@Setter
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private int profileID;
    @Column(name = "firsName")
    private String firsName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "postalCode")
    private String postalCode;
    @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL)
    private User userID;


//    @OneToOne
//    private User user;
}
