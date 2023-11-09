package com.example.patocheckout.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.patocheckout.entities.Product;
import com.example.patocheckout.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findProductById(long id) throws DataAccessException {
        return productRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAllProducts() throws DataAccessException {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) throws DataAccessException {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) throws DataAccessException {
        productRepository.delete(product);
    }
}
