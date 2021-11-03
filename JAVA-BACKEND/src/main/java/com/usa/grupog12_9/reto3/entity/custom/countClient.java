/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.grupog12_9.reto3.entity.custom;

import com.usa.grupog12_9.reto3.entity.Client;

/**
 *
 * @author juand
 */
public class countClient {
    private Long total;
    private Client client;

    public countClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    /*/**/
    
    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    
}
