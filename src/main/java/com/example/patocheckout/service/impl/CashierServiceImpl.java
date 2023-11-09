package com.example.patocheckout.service.impl;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.patocheckout.entities.Cashier;
import com.example.patocheckout.repositories.CashierRepository;
import com.example.patocheckout.service.CashierService;

public class CashierServiceImpl implements CashierService {

    private CashierRepository cashierRepository;

    @Override
    @Transactional(readOnly = true)
    public Collection<Cashier> findAllCashiers() throws DataAccessException {
        return cashierRepository.findAll();
    }

    @Override
    public Collection<Cashier> findByIsOpenTrue() throws DataAccessException {
        return cashierRepository.findByIsOpenTrue(true);
    }

    @Override
    public Collection<Cashier> findByIsOpenFalse() throws DataAccessException {
        return cashierRepository.findByIsOpenFalse(false);
    }

    @Override
    @Transactional
    public void deleteCashier(Cashier cashier) throws DataAccessException {
        cashierRepository.delete(cashier);
    }

    @Override
    @Transactional
    public void saveCashier(Cashier cashier) throws DataAccessException {
        cashierRepository.save(cashier);
    }
    
    @Override
    @Transactional
    public Collection<Cashier> findByIsOpen(boolean isOpen) throws DataAccessException {
        return cashierRepository.findByIsOpen(isOpen); 
   }

}
