package com.example.patocheckout.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;

import com.example.patocheckout.entities.Product;

public interface ProductService {

    Optional<Product> findProductById(long id) throws DataAccessException;

    List<Product> findAllProducts() throws DataAccessException;

    void saveProduct(Product product) throws DataAccessException;

    void deleteProduct(Product product) throws DataAccessException;
}
