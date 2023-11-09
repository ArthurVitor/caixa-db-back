package com.example.patocheckout.repositories;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import com.example.patocheckout.entities.Cashier;

@Repository
public interface CashierRepository{

    Collection<Cashier> findByIsOpenFalse(boolean isOpen) throws DataAccessException;
    Collection<Cashier> findByIsOpenTrue(boolean isOpen) throws DataAccessException; 
    Collection<Cashier> findAll() throws DataAccessException; 
    void delete(Cashier cashier) throws DataAccessException;
    void save(Cashier cashier) throws DataAccessException; 
}
