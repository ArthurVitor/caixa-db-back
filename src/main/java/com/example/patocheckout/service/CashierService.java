package com.example.patocheckout.service;
import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.example.patocheckout.entities.Cashier;

public interface CashierService {
    Collection<Cashier> findByIsOpen(boolean isOpen) throws DataAccessException;
}
