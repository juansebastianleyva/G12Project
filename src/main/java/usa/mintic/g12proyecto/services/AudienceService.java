package usa.mintic.g12proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.mintic.g12proyecto.entities.Audience;
import usa.mintic.g12proyecto.entities.Category;
import usa.mintic.g12proyecto.repository.AudienceRepository;
import usa.mintic.g12proyecto.repository.CategoryRepository;

import java.util.List;

@Service
public class AudienceService {

    @Autowired
    private AudienceRepository audienceRepository;

    public List<Audience> getAll(){
        return audienceRepository.getAll();
    }

    public Audience save(Audience c){
        return audienceRepository.save(c);
    }
}
