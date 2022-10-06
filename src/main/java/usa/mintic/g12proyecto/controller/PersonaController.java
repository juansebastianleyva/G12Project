package usa.mintic.g12proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import usa.mintic.g12proyecto.entities.Persona;
import usa.mintic.g12proyecto.services.PersonaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/all")
    public List<Persona> getAll(){
        return personaService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Persona> getById(@PathVariable("id") int idPersona){
        return personaService.getById(idPersona);

    }

    @PostMapping("/save")
    public Persona save(@RequestBody Persona p){
        return personaService.save(p);
    }
}
