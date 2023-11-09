package com.example.patocheckout.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.patocheckout.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findByCashierId(long cashierId);

}
