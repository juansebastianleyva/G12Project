package usa.mintic.g12proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import usa.mintic.g12proyecto.entities.Audience;
import usa.mintic.g12proyecto.entities.Category;
import usa.mintic.g12proyecto.entities.Persona;
import usa.mintic.g12proyecto.services.AudienceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Audience")
public class AudienceController {

    @Autowired
    private AudienceService audienceService;

    @GetMapping("/all")
    public List<Audience> getAll(){
        return audienceService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Audience save(@RequestBody Audience c){
        return audienceService.save(c);
    }

    @GetMapping("/{id}")
    public Optional<Audience> getById(@PathVariable("id") int idAudience){
        return audienceService.getById(idAudience);

    }

    @GetMapping("/cat/{idCat}")
    public List<Audience> getByCatId(@PathVariable("idCat") int idCategory){
        return audienceService.getByCat(idCategory);

    }
    @GetMapping("/desc/{desc}/{cap}")
    public List<Audience> getByDesc(@PathVariable("cap") int cap, @PathVariable("desc") String descp){
        return audienceService.getByDescAndCap(descp,cap);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED) 
    public Audience update(@RequestBody Audience a){
        return audienceService.update(a);
    }
}
