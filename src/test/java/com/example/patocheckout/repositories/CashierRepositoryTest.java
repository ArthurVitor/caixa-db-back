package com.example.patocheckout.repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;
import com.example.patocheckout.entities.Cashier;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
public class CashierRepositoryTest {
    
    @Autowired
    private CashierRepository cashierRepository;

    @Test
    public void testFindByIsOpen() {
        Cashier cashier = new Cashier(true, LocalDate.now());
        cashierRepository.save(cashier);

        List<Cashier> openCashiers = cashierRepository.findByIsOpen(true);
        assertThat(openCashiers).hasSize(1);
        assertThat(openCashiers.get(0).isOpen()).isEqualTo(true);
    }
}
