package com.usa.grupog12_9.reto3.crud;

import com.usa.grupog12_9.reto3.entity.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author GRUPO 9 G12
 * @reto RETO #3
 * 
 */
public interface MessageCrud extends CrudRepository<Message, Integer>{
    
}
