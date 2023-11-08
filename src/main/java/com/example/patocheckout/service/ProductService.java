package com.example.patocheckout.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.example.patocheckout.entities.Product;

public interface ProductService {

    Product findProductById(Long id) throws DataAccessException;

    Product findProductByBarCode(String barcode) throws DataAccessException;

    Collection<Product> findAllProducts(String barcode) throws DataAccessException;

    void saveProduct(Product product) throws DataAccessException;
    
    void deleteProduct(Product product) throws DataAccessException;
}
