package usa.mintic.g12proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import usa.mintic.g12proyecto.entities.Category;
import usa.mintic.g12proyecto.services.CategoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @PostMapping("/save")
    public Category save(@RequestBody Category c){
        return categoryService.save(c);
    }

    @GetMapping("/{id}")
    public Optional<Category> getById(@PathVariable("id") int idCat){
        return categoryService.getById(idCat);
    }

    @PutMapping("/update")
    public Category update(@RequestBody Category c){
        return categoryService.update(c);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return categoryService.delete(id);
    }


}
