package com.example.patocheckout.service;
import java.util.Collection;
import com.example.patocheckout.entities.Cashier;
import com.example.patocheckout.repositories.CashierRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CashierServiceImpl implements CashierService{

    private CashierRepository cashierRepository;
    
    @Autowired 
    public CashierServiceImpl (CashierRepository cashierRepository){
        this.cashierRepository = cashierRepository; 
    }

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
    public Collection<Cashier> findByIsOpenFalse() throws DataAccessException{
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
    
}
