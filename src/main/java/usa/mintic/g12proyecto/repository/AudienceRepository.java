package usa.mintic.g12proyecto.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.mintic.g12proyecto.entities.Audience;
import usa.mintic.g12proyecto.entities.Category;
import usa.mintic.g12proyecto.repository.crud.AudienceCRUDRepository;
import usa.mintic.g12proyecto.repository.crud.CategoryCRUDRepository;

import java.util.List;

@Repository
public class AudienceRepository {

    @Autowired
    private AudienceCRUDRepository audienceCRUDRepository;

    public List<Audience> getAll(){
        return (List<Audience>) audienceCRUDRepository.findAll();
    }

    public Audience save(Audience c){
        return audienceCRUDRepository.save(c);
    }

}
