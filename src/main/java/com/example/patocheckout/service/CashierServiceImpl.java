package com.example.patocheckout.service;
import java.util.Collection;
import com.example.patocheckout.entities.Cashier;
import com.example.patocheckout.repositories.CashierRepository;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CashierServiceImpl implements CashierService{

    private CashierRepository cashierRepository;

    @Override
    @Transactional(readOnly = true)
    public Collection<Cashier> findByIsOpen(boolean isOpen) throws DataAccessException {
        return cashierRepository.findByIsOpen(isOpen); 
    }
    
}
