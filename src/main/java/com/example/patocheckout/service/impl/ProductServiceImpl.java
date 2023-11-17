package com.example.patocheckout.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.patocheckout.entities.Product;
import com.example.patocheckout.repositories.ProductRepository;
import com.example.patocheckout.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findProductById(long id) throws DataAccessException {
        return productRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findProductByBarcode(String barcode) throws DataAccessException {
        return productRepository.findByBarcode(barcode);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAllProducts() throws DataAccessException {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public Product saveProduct(Product product) throws DataAccessException {
        productRepository.save(product);
        return product;
    }

    @Override
    @Transactional
    public void deleteProduct(Product product) throws DataAccessException {
        productRepository.delete(product);
    }
}
