package com.example.patocheckout.service;

import java.util.Collection;

import com.example.patocheckout.entities.Product;
import com.example.patocheckout.repositories.ProductRepository;

import jakarta.transaction.Transactional;

public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    
    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product findProductByBarCode(String barcode) {
        return productRepository.findByBarCode(barcode);
    }

    @Override
    public Collection<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}
