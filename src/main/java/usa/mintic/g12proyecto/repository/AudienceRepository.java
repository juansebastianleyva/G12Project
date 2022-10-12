package usa.mintic.g12proyecto.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.mintic.g12proyecto.entities.Audience;
import usa.mintic.g12proyecto.entities.Category;
import usa.mintic.g12proyecto.repository.crud.AudienceCRUDRepository;
import usa.mintic.g12proyecto.repository.crud.CategoryCRUDRepository;

import java.util.List;
import java.util.Optional;

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

    public Optional<Audience> getById(int i){
        return  audienceCRUDRepository.findById(i);
    }

    public  List<Audience> getByCategoryId(int idCat){
        //return audienceCRUDRepository.findByCategoryIdOrderByNameAsc(idCat);
        return  audienceCRUDRepository.findByCapacityGreaterThanEqual(idCat);
    }
    public  List<Audience> getByDesc(String desc,int cap){
        return audienceCRUDRepository.findByDescriptionContainsAndAndCapacityGreaterThan(desc, cap);
    }
    public void delete(Audience a){
        audienceCRUDRepository.delete(a);
    }

}
