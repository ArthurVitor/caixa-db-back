package com.example.patocheckout.entities;
import java.time.LocalDate;
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
    protected Long id;

    @Column(nullable = false)
    private boolean isOpen;

    @Column(nullable = false)
    private LocalDate openDate = LocalDate.now();

    private LocalDate closeDate;

    public void setId(Long id) {
        this.id = id;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public void setOpenDate(LocalDate openDate) {
        this.openDate = openDate;
    }

    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }  

    public Long getId() {
        return id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public LocalDate getOpenDate() {
        return openDate;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public void openCashier(){
        this.isOpen = true; 
        this.openDate = LocalDate.now(); 
    }

    public void closeCashier(){
        this.isOpen = false; 
        this.closeDate = LocalDate.now(); 
    }
}
