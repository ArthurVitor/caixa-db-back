package com.example.patocheckout.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.patocheckout.entities.Product;

import jakarta.transaction.Transactional;

@SpringBootTest
@ActiveProfiles({"jpa"})
public class ProductServiceTest {
    
    @Autowired
    private ProductService productService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Transactional
    public void shouldCreateProduct() {
        int initialNumberOfProducts = productService.findAllProducts().size();
        Product createdProduct = productService.saveProduct(new Product("Banana", 0.50, "36"));

        assertThat(createdProduct == null).isFalse();
        assertThat(productService.findProductById(createdProduct.getId()) == null).isFalse();
        assertThat(productService.findAllProducts().size()).isEqualTo(initialNumberOfProducts + 1);
    }
}
