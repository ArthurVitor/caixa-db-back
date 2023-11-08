package com.example.patocheckout.service;

import java.util.Collection;

import org.springframework.data.domain.Pageable;

import com.example.patocheckout.entities.Sale;

public interface SaleService {

    Sale findSaleById(long id);

    Collection<Sale> findAllSales();

    Collection<Sale> findAllSales(Pageable pageable);

    default Collection<Sale> findAllSales(int page, int perPage) {
        return findAllSales(Pageable.ofSize(perPage).withPage(page));
    }

    Sale createSale(Sale sale);

    void deleteSale(Sale sale);
    
}
