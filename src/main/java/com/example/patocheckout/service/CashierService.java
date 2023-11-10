package com.example.patocheckout.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.example.patocheckout.entities.Cashier;

public interface CashierService {
    Collection<Cashier> findByIsOpen(boolean isOpen) throws DataAccessException;
    Collection<Cashier> findAll() throws DataAccessException; 
    Cashier findById(Long id) throws DataAccessException; 
    void save(Cashier cashier) throws DataAccessException;
    void delete(Cashier cashier) throws DataAccessException;
}
