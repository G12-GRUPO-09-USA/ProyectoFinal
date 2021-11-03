package com.usa.grupog12_9.reto3.repository;

import com.usa.grupog12_9.reto3.entity.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.usa.grupog12_9.reto3.crud.MessageCrud;

/**
 *
 * @author GRUPO 9 G12
 * @reto RETO #3
 * 
 */

@Repository
public class MessageRepository {
    @Autowired
    private MessageCrud messageCrud;
    
    public List<Message> getAll(){
        return (List<Message>) messageCrud.findAll();
    }
    public Optional<Message> getMessage(int id){
        return messageCrud.findById(id);
    }
    public Message save(Message message){
        return messageCrud.save(message);
    }
    public void delete(Message message){
        messageCrud.delete(message);
    }    
}
