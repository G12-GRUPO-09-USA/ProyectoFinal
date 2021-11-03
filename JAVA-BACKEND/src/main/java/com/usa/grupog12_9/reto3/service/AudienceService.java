package com.usa.grupog12_9.reto3.service;

import com.usa.grupog12_9.reto3.entity.Audience;
import com.usa.grupog12_9.reto3.repository.AudienceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author GRUPO 9 G12
 * @reto RETO #3
 * 
 */

@Service
public class AudienceService {
    
    @Autowired
    private AudienceRepository audienceRepository;
    
    public List<Audience> getAll(){
        return audienceRepository.getAll();
    }
    
    public Optional<Audience> getAudience(int id){
        return audienceRepository.getAudience(id);
    }
    
    public Audience save(Audience a){
        if(a.getId()==null){
            return audienceRepository.save(a);
        }
        else{
        Optional<Audience> paux=audienceRepository.getAudience(a.getId());
        if(paux.isEmpty()){
            return audienceRepository.save(a);
        }
        else{
            return a;
        }
        }
    }
    
    public Audience update(Audience audience){
        if(audience.getId()!=null){
            Optional<Audience>save=audienceRepository.getAudience(audience.getId());
            if(!save.isEmpty()){
                if(audience.getName()!=null){
                    save.get().setName(audience.getName());                 
                }
                if(audience.getOwner()!=null){
                    save.get().setOwner(audience.getOwner());
                }
                if(audience.getCapacity()!=null){
                    save.get().setCapacity(audience.getCapacity());
                }
                if(audience.getCategory()!=null){
                    save.get().setCategory(audience.getCategory());
                }
                if(audience.getDescription()!=null){
                    save.get().setDescription(audience.getDescription());
                }
                return audienceRepository.save(save.get());
            }
        }
        return audience;
    }
        
    public boolean delete(int id){
        Optional<Audience> audience=getAudience(id);
        if(!audience.isEmpty()){
            audienceRepository.delete(audience.get());
            return true;
        }
        return false;
    }
}
