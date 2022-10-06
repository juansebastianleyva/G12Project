package usa.mintic.g12proyecto.controller;

import org.springframework.web.bind.annotation.*;
import usa.mintic.g12proyecto.entities.Persona;

@RestController
@RequestMapping("/api/G12")
public class MyController {

    @GetMapping("/hola")
    public String saludar(){
        return "<h1>Hola mundo!</h1>";
    }


    @PostMapping("/persona")
    public Persona recibirData(@RequestBody Persona p){
        System.out.println(p.getName());
        return p;
    }


}
