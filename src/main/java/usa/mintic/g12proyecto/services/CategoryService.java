package usa.mintic.g12proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.mintic.g12proyecto.entities.Category;
import usa.mintic.g12proyecto.repository.CategoryRepository;
import usa.mintic.g12proyecto.repository.crud.CategoryCRUDRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Category save(Category c){
        return categoryRepository.save(c);
    }
}
