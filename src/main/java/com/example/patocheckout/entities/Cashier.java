package com.example.patocheckout.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cashiers")
public class Cashier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(nullable = false)
    private boolean isOpen;

    @Column(nullable = false)
    private LocalDate openDate;

    private LocalDate closeDate;

    public void openCashier() {
        this.isOpen = true;
        this.openDate = LocalDate.now(); 
    }

    public void closeCashier() {
        this.isOpen = false;
        this.closeDate = LocalDate.now(); 
    }

}
