package com.usa.grupog12_9.reto3.crud;

import com.usa.grupog12_9.reto3.entity.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author GRUPO 9 G12
 * @reto RETO #3
 * 
 */
public interface ReservationCrud extends CrudRepository<Reservation, Integer>{
   
    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c group by c.client order by COUNT(c.client) desc")
    public List<Object[]> countTotalReservationByClient();
    
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    public List<Reservation> findAllByStatus(String status);
    
}
