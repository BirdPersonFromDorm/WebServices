package Web.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "service")
@Getter
@Setter
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private int serviceID;
    @Column(name = "serviceName")
    private String serviceName;
    @Column(name = "isActive")
    private boolean isActive;
    @Column(name = "serviceMonthPrice")
    private double serviceMonthPrice;
    @ManyToMany(cascade=CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "user_services",
            joinColumns = { @JoinColumn(name = "service_id")},
            inverseJoinColumns = { @JoinColumn(name = "User_id")})
    private Set<User> user;

}
