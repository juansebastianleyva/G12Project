package usa.mintic.g12proyecto.repository;

import org.aspectj.weaver.patterns.PerObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.mintic.g12proyecto.entities.Persona;
import usa.mintic.g12proyecto.repository.crud.PersonaCRUDRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonaRepository {

    @Autowired
    private PersonaCRUDRepository personaCRUDRepository;

    public List<Persona> getAll(){
        return (List<Persona>) personaCRUDRepository.findAll();
    }

    public Persona save(Persona p){
        return personaCRUDRepository.save(p);
    }

    public Optional<Persona> getById(int id){
        return personaCRUDRepository.findById(id);
    }
    public void delete(Persona p){
        personaCRUDRepository.delete(p);
    }


}
