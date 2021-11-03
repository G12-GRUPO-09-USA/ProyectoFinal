package com.usa.grupog12_9.reto3.repository;

import com.usa.grupog12_9.reto3.entity.Audience;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.usa.grupog12_9.reto3.crud.AudienceCrud;

/**
 *
 * @author GRUPO 9 G12
 * @reto RETO #3
 * 
 */

@Repository
public class AudienceRepository {
    
    @Autowired
    private AudienceCrud audienceCrud;
    
    public List<Audience> getAll(){
        return (List<Audience>) audienceCrud.findAll();
    }
    public Optional<Audience> getAudience(int id){
        return audienceCrud.findById(id);
    }
    public Audience save(Audience audience){
        return audienceCrud.save(audience);
    }
    public void delete(Audience audience){
        audienceCrud.delete(audience);
    }        
}
