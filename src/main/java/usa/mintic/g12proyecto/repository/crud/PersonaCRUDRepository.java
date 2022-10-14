package usa.mintic.g12proyecto.repository.crud;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import usa.mintic.g12proyecto.entities.Persona;

import java.util.List;

public interface PersonaCRUDRepository extends CrudRepository<Persona,Integer> {

    @Query("SELECT p.age, COUNT(p.age) FROM Persona AS p group by p.age order by COUNT(p.age)  DESC")
    public List<Object[]> totalPersonasPorEdad();

    //Object[] p ------> p[0] Edad!   p[1] CONTEO!!!


}
