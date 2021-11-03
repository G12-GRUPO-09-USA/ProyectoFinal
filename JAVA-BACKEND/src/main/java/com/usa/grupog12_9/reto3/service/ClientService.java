package com.usa.grupog12_9.reto3.service;

import com.usa.grupog12_9.reto3.entity.Client;
import com.usa.grupog12_9.reto3.repository.ClientRepository;
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
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    public Client save(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        }
        else{
        Optional<Client> paux=clientRepository.getClient(client.getIdClient());
        if(paux.isEmpty()){
            return clientRepository.save(client);
        }
        else{
            return client;
        }
        }
    }
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client>save=clientRepository.getClient(client.getIdClient());
            if(!save.isEmpty()){
                if(client.getName()!=null){
                    save.get().setName(client.getName());
                 
                }
                if(client.getAge()!=null){
                    save.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    save.get().setPassword(client.getPassword());
                }                
                return clientRepository.save(save.get());
            }
        }
        return client;
    }
        
    public boolean delete(int id){
        Optional<Client> client=getClient(id);
        if(!client.isEmpty()){
            clientRepository.delete(client.get());
            return true;
        }
        return false;
    }    
}
