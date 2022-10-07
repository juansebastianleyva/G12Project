package usa.mintic.g12proyecto.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;

    private Date startDate;
    private Date devolutionDate;
    private String status="created";


    @ManyToOne
    @JoinColumn(name="audienceId")
    private Audience audience;

}
