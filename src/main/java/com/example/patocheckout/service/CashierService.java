package com.example.patocheckout.service;
import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.example.patocheckout.entities.Cashier;

public interface CashierService {
    Collection<Cashier> findAllCashiers() throws DataAccessException;
    Collection<Cashier> findByIsOpenTrue() throws DataAccessException;
    Collection<Cashier> findByIsOpenFalse() throws DataAccessException; 
    void deleteCashier(Cashier cashier) throws DataAccessException;     
    void saveCashier(Cashier cashier) throws DataAccessException; 
}
