package com.usa.grupog12_9.reto3.repository;

import com.usa.grupog12_9.reto3.entity.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.usa.grupog12_9.reto3.crud.ClientCrud;

/**
 *
 * @author GRUPO 9 G12
 * @reto RETO #3
 * 
 */

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrud clientCrud;
    
    public List<Client> getAll(){
        return (List<Client>) clientCrud.findAll();
    }
    public Optional<Client> getClient(int id){
        return clientCrud.findById(id);
    }
    public Client save(Client client){
        return clientCrud.save(client);
    }
    public void delete(Client client){
        clientCrud.delete(client);
    }
}
