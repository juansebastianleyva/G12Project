package usa.mintic.g12proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.mintic.g12proyecto.entities.Category;
import usa.mintic.g12proyecto.repository.CategoryRepository;
import usa.mintic.g12proyecto.repository.crud.CategoryCRUDRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Category save(Category c){
        if(c.getId()==null){
            return categoryRepository.save(c);
        }
        return c;
    }

    public Category update(Category c){
        if(c.getId()!=null){
            Optional<Category> opt=categoryRepository.getById(c.getId());
            if(opt.isPresent()){
                Category oldCat= opt.get();
                if(c.getName()!=null){
                    oldCat.setName(c.getName());
                }
                if(c.getDescription()!=null){
                    oldCat.setDescription(c.getDescription());
                }
                return categoryRepository.save(oldCat);
            }
        }
        return c;
    }
    public boolean delete(int id){

        Optional<Category> c=categoryRepository.getById(id);
        if(c.isPresent()){
            categoryRepository.delete(c.get());
            return true;
        }else{
            return false;
        }

    }


    public Optional<Category> getById(int idCat){
        return categoryRepository.getById(idCat);
    }
}
