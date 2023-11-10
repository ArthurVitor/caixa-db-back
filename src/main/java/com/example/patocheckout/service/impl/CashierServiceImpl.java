package com.example.patocheckout.service.impl;
import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.patocheckout.entities.Cashier;
import com.example.patocheckout.repositories.CashierRepository;
import com.example.patocheckout.service.CashierService;

@Service
public class CashierServiceImpl implements CashierService{

    private CashierRepository cashierRepository;

    @Override
    @Transactional(readOnly = true)
    public Collection<Cashier> findByIsOpen(boolean isOpen) throws DataAccessException {
        return cashierRepository.findByIsOpen(isOpen); 
    }

    @Override
    public Collection<Cashier> findAll() throws DataAccessException {
        return cashierRepository.findAll();
    }

    @Override
    public Cashier findById(Long id) throws DataAccessException {
        return cashierRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Cashier cashier) throws DataAccessException {
        cashierRepository.save(cashier);
    }

    @Override
    public void delete(Cashier cashier) throws DataAccessException {
        cashierRepository.delete(cashier);
    }

}
