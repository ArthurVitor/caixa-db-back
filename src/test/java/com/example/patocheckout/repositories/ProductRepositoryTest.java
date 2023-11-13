package com.example.patocheckout.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.patocheckout.entities.Product;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFindAll() {
        Product product = new Product("Ovo", 0.75, "a");
        entityManager.persistAndFlush(product);

        List<Product> productByBarCode = productRepository.findByBarcode("a");
        assertThat(productByBarCode).hasSize(1);
        assertThat(productByBarCode.get(0).getName()).isEqualTo("Ovo");
    }
    
}
