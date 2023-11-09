package com.example.patocheckout.service.impl;

import java.util.Collection;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.patocheckout.entities.Sale;
import com.example.patocheckout.repositories.SaleRepository;
import com.example.patocheckout.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService {

    private SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Sale findSaleById(long id) {
        return saleRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Sale> findAllSales() {
        return saleRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Sale> findAllSales(Pageable pageable) {
        return saleRepository.findAll(pageable).getContent();
    }

    @Override
    @Transactional
    public Sale createSale(Sale sale) {
        return this.saleRepository.save(sale);
    }

    @Override
    @Transactional
    public void deleteSale(Sale sale) {
        this.saleRepository.delete(sale);
    }
    
}
