package usa.mintic.g12proyecto.repository.crud;

import org.springframework.data.repository.CrudRepository;
import usa.mintic.g12proyecto.entities.Persona;

public interface PersonaCRUDRepository extends CrudRepository<Persona,Integer> {
}
