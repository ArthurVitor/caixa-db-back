package com.example.patocheckout.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.patocheckout.entities.Sale;

import jakarta.transaction.Transactional;

@SpringBootTest
@ActiveProfiles({"jpa"})
public class SaleServiceTest {

    @Autowired
    private SaleService saleService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Transactional
    public void shouldCreateSale() {
        int initialNumberOfSales = saleService.findAllSales().size();
        var createdSale = saleService.createSale(new Sale());

        assertThat(createdSale == null).isFalse();
        assertThat(saleService.findSaleById(createdSale.getId()) == null).isFalse();
        assertThat(saleService.findAllSales().size()).isEqualTo(initialNumberOfSales + 1);
    }
}
