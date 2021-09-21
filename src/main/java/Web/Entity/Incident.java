package Web.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "incident")
@Getter
@Setter
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "incident_id")
    private int incidentID;
    @Column(name = "service_name")
    private String serviceName;
    @Column(name = "isActive")
    private boolean isActive;
    @Column(name = "problemDescription")
    private String problemDescription;
    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User users;

}
