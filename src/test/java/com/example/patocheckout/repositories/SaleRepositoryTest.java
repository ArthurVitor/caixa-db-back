package com.example.patocheckout.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.patocheckout.entities.Cashier;
import com.example.patocheckout.entities.Sale;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SaleRepositoryTest {
    
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private CashierRepository cashierRepository;

    @Test
    public void testFindByIsOpen() {
        Cashier cashier = new Cashier(true, LocalDateTime.now());

        cashierRepository.save(cashier);

        Sale sale = new Sale();

        saleRepository.save(sale);

        List<Sale> openSales = saleRepository.findAll();

        assertThat(openSales).hasSize(1);
        assertThat(openSales.get(0).getPaidAmount()).isEqualTo(BigDecimal.ZERO);
    }
}
