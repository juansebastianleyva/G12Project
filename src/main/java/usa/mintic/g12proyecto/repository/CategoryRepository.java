package usa.mintic.g12proyecto.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.mintic.g12proyecto.entities.Category;
import usa.mintic.g12proyecto.repository.crud.CategoryCRUDRepository;

import java.util.List;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCRUDRepository categoryCRUDRepository;

    public List<Category> getAll(){
        return (List<Category>) categoryCRUDRepository.findAll();
    }

    public Category save(Category c){
        return categoryCRUDRepository.save(c);
    }

}
