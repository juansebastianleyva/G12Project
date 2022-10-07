package usa.mintic.g12proyecto.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Audience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String owner;
    private Integer capacity;
    private String description;

    @ManyToOne
    @JoinColumn(name="categoryId")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "audience")
    private List<Reservation> reservations;
}
