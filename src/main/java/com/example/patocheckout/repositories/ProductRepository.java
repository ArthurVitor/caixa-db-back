package com.example.patocheckout.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.patocheckout.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
