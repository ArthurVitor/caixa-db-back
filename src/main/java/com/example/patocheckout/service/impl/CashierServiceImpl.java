package com.example.patocheckout.service.impl;
import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.patocheckout.entities.Cashier;
import com.example.patocheckout.repositories.CashierRepository;
import com.example.patocheckout.service.CashierService;

@Service
public class CashierServiceImpl implements CashierService{

    private final CashierRepository cashierRepository;

    public CashierServiceImpl(CashierRepository cashierRepository) {
        this.cashierRepository = cashierRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Cashier> findByIsOpen(boolean isOpen) throws DataAccessException {
        return cashierRepository.findByIsOpen(isOpen); 
    }

    @Override
    public Collection<Cashier> findAll() throws DataAccessException {
        return cashierRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Cashier findById(Long id) throws DataAccessException {
        return cashierRepository.findById(id).orElse(null);
    }

    @Override
    public Cashier save(Cashier cashier) throws DataAccessException {
        Cashier created = cashierRepository.save(cashier);
        System.out.println(created);
        return created;
    }

    @Override
    public Cashier findSaleById(long id) throws DataAccessException {
        return cashierRepository.findBySalesId(id);
    }
    
}
