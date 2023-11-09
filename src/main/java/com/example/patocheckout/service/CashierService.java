package com.example.patocheckout.service;

import java.util.Collection;
import com.example.patocheckout.entities.Cashier;

public interface CashierService {

    Collection<Cashier> findAllCashiers();
    Collection<Cashier> findByIsOpenTrue();
    Collection<Cashier> findByIsOpenFalse(); 
    void deleteCashier(Cashier cashier); 
}
