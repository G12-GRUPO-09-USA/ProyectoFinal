package com.usa.grupog12_9.reto3.service;

import com.usa.grupog12_9.reto3.entity.Reservation;
import com.usa.grupog12_9.reto3.entity.custom.DescriptionAmount;
import com.usa.grupog12_9.reto3.entity.custom.countClient;
import com.usa.grupog12_9.reto3.repository.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        }
        else{
        Optional<Reservation> paux=reservationRepository.getReservation(reservation.getIdReservation());
        if(paux.isEmpty()){
            return reservationRepository.save(reservation);
        }
        else{
            return reservation;
        }
        }
    }
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation>save=reservationRepository.getReservation(reservation.getIdReservation());
            if(!save.isEmpty()){
                if(reservation.getStartDate()!=null){
                    save.get().setStartDate(reservation.getStartDate());
                 
                }
                if(reservation.getDevolutionDate()!=null){
                    save.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    save.get().setStatus(reservation.getStatus());
                }
                return reservationRepository.save(save.get());
            }
        }
        return reservation;
    }
        
    public boolean delete(int id){
        Optional<Reservation> client=getReservation(id);
        if(!client.isEmpty()){
            reservationRepository.delete(client.get());
            return true;
        }
        return false;
    }    
    
    public List<countClient> getTopClients(){
        return reservationRepository.getTopClients();
    }
    
    public DescriptionAmount getStatusReport(){
        List<Reservation> completed=reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled=reservationRepository.getReservationByStatus("cancelled");
        
        DescriptionAmount descAmt=new DescriptionAmount(completed.size(), cancelled.size());
        return descAmt;
        
    }
    
    public List<Reservation> getReservationPeriod(String d1, String d2){
        
        // yyyy-mm-dd
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd"); 
        Date dateOne=new Date();
        Date dateTwo=new Date();
        try{
            dateOne=parser.parse(d1);
            dateTwo=parser.parse(d2);
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        
        if(dateOne.before(dateTwo)){
           return reservationRepository.getReservationPeriod(dateOne, dateTwo);
        }else{
            return new ArrayList<>();
        }
        
        
        
    }
}
