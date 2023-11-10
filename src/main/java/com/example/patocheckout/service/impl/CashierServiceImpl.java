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

}
