package com.example.patocheckout.repositories;

import java.math.BigDecimal;
import java.util.List; 
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.patocheckout.entities.Cashier;

@Repository
public interface CashierRepository extends JpaRepository<Cashier, Long>{
    List<Cashier> findByIsOpen(boolean isOpen) throws DataAccessException;
    BigDecimal getTotal(Long cashier_id) throws DataAccessException;
}
