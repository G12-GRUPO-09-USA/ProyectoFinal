package com.usa.grupog12_9.reto3.service;

import com.usa.grupog12_9.reto3.entity.Message;
import com.usa.grupog12_9.reto3.repository.MessageRepository;
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
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    public Message save(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        }
        else{
        Optional<Message> paux=messageRepository.getMessage(message.getIdMessage());
        if(paux.isEmpty()){
            return messageRepository.save(message);
        }
        else{
            return message;
        }
        }
    }
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message>save=messageRepository.getMessage(message.getIdMessage());
            if(!save.isEmpty()){
                if(message.getMessageText()!=null){
                    save.get().setMessageText(message.getMessageText());
                 
                }
                return messageRepository.save(save.get());
            }
        }
        return message;
    }
        
    public boolean delete(int id){
        Optional<Message> client=getMessage(id);
        if(!client.isEmpty()){
            messageRepository.delete(client.get());
            return true;
        }
        return false;
    }    
}
