package usa.mintic.g12proyecto.repository.crud;

import org.springframework.data.repository.CrudRepository;
import usa.mintic.g12proyecto.entities.Audience;
import usa.mintic.g12proyecto.entities.Category;

public interface AudienceCRUDRepository extends CrudRepository<Audience,Integer> {
}
