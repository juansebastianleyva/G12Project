package usa.mintic.g12proyecto.repository.crud;

import org.springframework.data.repository.CrudRepository;
import usa.mintic.g12proyecto.entities.Audience;
import usa.mintic.g12proyecto.entities.Category;

import java.util.List;

public interface AudienceCRUDRepository extends CrudRepository<Audience,Integer> {

    public List<Audience> findByCategoryIdOrderByNameAsc(int categoryId);

    public List<Audience> findByCapacityGreaterThanEqual(int capacity);

    public List<Audience> findByDescriptionContainsAndAndCapacityGreaterThan(String description,int capacity);

}
