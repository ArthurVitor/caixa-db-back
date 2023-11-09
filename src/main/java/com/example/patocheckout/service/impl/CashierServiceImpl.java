package com.example.patocheckout.service.impl;

import java.util.Collection;

import com.example.patocheckout.entities.Cashier;
import com.example.patocheckout.repositories.CashierRepository;
import com.example.patocheckout.service.CashierService;

import org.springframework.transaction.annotation.Transactional;

public class CashierServiceImpl implements CashierService {

    private CashierRepository cashierRepository;

    @Override
    @Transactional(readOnly = true)
    public Collection<Cashier> findAllCashiers() {
       return cashierRepository.findAll(); 
    }

    @Override
    public Collection<Cashier> findByIsOpenTrue() {
        return cashierRepository.findByIsOpenTrue(true); 
    }

    @Override
    public Collection<Cashier> findByIsOpenFalse() {
       return cashierRepository.findByIsOpenFalse(false); 
    }

    @Override
	@Transactional
	public void deleteCashier(Cashier cashier) {
		cashierRepository.delete(cashier);
	}
    
}
