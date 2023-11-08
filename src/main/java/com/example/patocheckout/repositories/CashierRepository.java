package com.example.patocheckout.repositories;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import com.example.patocheckout.entities.Cashier;

@Repository
public interface CashierRepository{

    Collection<Cashier> findByIsOpenFalse(boolean isOpen);
    Collection<Cashier> findByIsOpenTrue(boolean isOpen); 
    Collection<Cashier> findAll(); 
    void delete(Cashier cashier); 
}
