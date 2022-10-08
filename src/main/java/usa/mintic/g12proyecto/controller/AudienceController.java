package usa.mintic.g12proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import usa.mintic.g12proyecto.entities.Audience;
import usa.mintic.g12proyecto.entities.Category;
import usa.mintic.g12proyecto.services.AudienceService;

import java.util.List;

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
    public Audience save(@RequestBody Audience c){
        return audienceService.save(c);
    }
}
