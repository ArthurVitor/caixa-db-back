package com.example.patocheckout.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.patocheckout.entities.Product;
import com.example.patocheckout.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findProductById(long id) {
        return productRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Product findProductByBarCode(String barcode) {
        return productRepository.findByBarCode(barcode);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAllProducts() {
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
