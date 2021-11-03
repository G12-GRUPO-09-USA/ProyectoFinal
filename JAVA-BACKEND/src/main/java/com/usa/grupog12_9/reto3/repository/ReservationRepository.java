package com.usa.grupog12_9.reto3.repository;

import com.usa.grupog12_9.reto3.entity.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.usa.grupog12_9.reto3.crud.ReservationCrud;
import com.usa.grupog12_9.reto3.entity.Client;
import com.usa.grupog12_9.reto3.entity.custom.countClient;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author GRUPO 9 G12
 * @reto RETO #3
 * 
 */

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrud reservationCrud;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrud.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrud.findById(id);
    }
    public Reservation save(Reservation reservation){
        return reservationCrud.save(reservation);
    }
    public void delete(Reservation reservation){
        reservationCrud.delete(reservation);
    }   
    
    
    public List<Reservation> getReservationByStatus(String status){
        return reservationCrud.findAllByStatus(status);
    }
    
    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo){
        return reservationCrud.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }
    
    public List<countClient> getTopClients(){
        List<countClient> res=new ArrayList<>();
        
        List<Object[]> report=reservationCrud.countTotalReservationByClient();
        for(int i=0;i<report.size();i++){
            Client cli=(Client)report.get(i)[0];
            Long cantidad=(Long) report.get(i)[1];
            countClient cc=new countClient(cantidad,cli);
            res.add(cc);
        }
        
        return res;
    }
}
