package usa.mintic.g12proyecto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.mintic.g12proyecto.entities.Category;
import usa.mintic.g12proyecto.entities.Persona;
import usa.mintic.g12proyecto.repository.PersonaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public Persona save(Persona p){
        if(p.getId()==null){
            return personaRepository.save(p);
        }
        return p;
    }

    public List<Persona> getAll(){
        return personaRepository.getAll();
    }
    public Optional<Persona> getById(int id){
        return personaRepository.getById(id);
    }

    public boolean delete(int id){

        Optional<Persona> c=personaRepository.getById(id);
        if(c.isPresent()){
            personaRepository.delete(c.get());
            return true;
        }else{
            return false;
        }

    }

    public Persona update (Persona c){
        if(c.getId()!=null){
            Optional<Persona> opt=personaRepository.getById(c.getId());
            if(opt.isPresent()){
                Persona oldPerson= opt.get();
                if(c.getName()!=null){
                    oldPerson.setName(c.getName());
                }
                if(c.getEmail()!=null){
                    oldPerson.setEmail(c.getEmail());
                }
                if(c.getAge()!=null){
                    oldPerson.setAge(c.getAge());
                }

                return personaRepository.save(oldPerson);
            }
        }
        return c;
    }
}
