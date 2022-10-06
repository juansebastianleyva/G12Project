package usa.mintic.g12proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.mintic.g12proyecto.entities.Persona;
import usa.mintic.g12proyecto.repository.PersonaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public Persona save(Persona p){
        return personaRepository.save(p);
    }

    public List<Persona> getAll(){
        return personaRepository.getAll();
    }
    public Optional<Persona> getById(int id){
        return personaRepository.getById(id);
    }
}
