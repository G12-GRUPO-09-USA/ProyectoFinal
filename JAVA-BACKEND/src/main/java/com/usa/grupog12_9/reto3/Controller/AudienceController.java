package com.usa.grupog12_9.reto3.Controller;

import com.usa.grupog12_9.reto3.entity.Audience;
import com.usa.grupog12_9.reto3.service.AudienceService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author GRUPO 9 G12
 * @reto RETO #3
 * 
 */
@RestController
@RequestMapping("/api/Audience")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AudienceController {
    @Autowired
    private AudienceService audienceService;
    @GetMapping("/all")
    public List<Audience> getAudiences(){
        return audienceService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Audience>getAudience(@PathVariable("id")int id){
        return audienceService.getAudience(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Audience save(@RequestBody Audience audience){
        return audienceService.save(audience);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Audience update(@RequestBody Audience audience){
        return audienceService.update(audience);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteAudience(@PathVariable("id")int id){
        return audienceService.delete(id);
    }     
}
