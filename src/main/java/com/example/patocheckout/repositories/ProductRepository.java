package com.example.patocheckout.repositories;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.example.patocheckout.entities.Product;

@Repository
public interface ProductRepository {
    
    Product findById(Long id);
    Product findByBarCode(String barcode);
    Collection<Product> findAll();
    void save(Product product);
    void delete(Product product);
}
