package usa.mintic.g12proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.mintic.g12proyecto.entities.Audience;
import usa.mintic.g12proyecto.entities.Category;
import usa.mintic.g12proyecto.repository.AudienceRepository;
import usa.mintic.g12proyecto.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AudienceService {

    @Autowired
    private AudienceRepository audienceRepository;

    public List<Audience> getAll(){
        return audienceRepository.getAll();
    }

    public Audience save(Audience c){
        if(c.getId()==null){
            return audienceRepository.save(c);
        }else{
            Optional<Audience> pa=audienceRepository.getById(c.getId());
            if(!pa.isPresent()){
                return audienceRepository.save(c);
            }
        }
        return c;

    }

    public Optional<Audience> getById(int id){
        return audienceRepository.getById(id);
    }
    public List<Audience> getByCat(int id){
        return audienceRepository.getByCategoryId(id);
    }
    public List<Audience>getByDescAndCap(String d,int c){
        return audienceRepository.getByDesc(d, c);
    }
    public Audience update(Audience a){
        if(a.getId()!=null){
            Optional<Audience> pa=audienceRepository.getById(a.getId());
            if(pa.isPresent()){
                Audience result=pa.get();
                if(a.getCapacity()!=null){
                    result.setCapacity(a.getCapacity());
                }
                if(a.getCategory()!=null){
                    result.setCategory(a.getCategory());
                }
                if(a.getDescription()!=null){
                    result.setDescription(a.getDescription());
                }
                if(a.getName()!=null){
                    result.setName(a.getName());
                }
                if(a.getOwner()!=null){
                    result.setOwner(a.getOwner());
                }
                return audienceRepository.save(result);
            }
        }
        return a;
    }


}
