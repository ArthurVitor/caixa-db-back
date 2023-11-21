package com.example.patocheckout.entities;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cashiers")
public class Cashier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    private boolean isOpen = true;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") 
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(nullable = false)
    private LocalDateTime openDate = LocalDateTime.now();

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") 
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(nullable = true)
    private LocalDateTime closeDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    private List<Sale> sales; 

    public Cashier(boolean isOpen, LocalDateTime openDate) {
        this.sales = new ArrayList<>();
        this.isOpen = isOpen;
        this.openDate = openDate;
    }

    public Cashier() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public void setOpenDate(LocalDateTime openDate) {
        if (openDate != null) {
            this.openDate = openDate;
        }
    }

    public void setCloseDate(LocalDateTime closeDate) {
        this.closeDate = closeDate;
    }  

    public Long getId() {
        return id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public LocalDateTime getOpenDate() {
        return openDate;
    }

    public LocalDateTime getCloseDate() {
        return closeDate;
    }

    public void openCashier(){
        this.isOpen = true; 
        this.openDate = LocalDateTime.now(); 
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public void closeCashier(){
        this.isOpen = false; 
        this.closeDate = LocalDateTime.now(); 
    }

    @Override
    public String toString() {
        return "Cashier [id=" + id + ", isOpen=" + isOpen + ", openDate=" + openDate + ", closeDate=" + closeDate
                + ", sales=" + sales + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + (isOpen ? 1231 : 1237);
        result = prime * result + ((openDate == null) ? 0 : openDate.hashCode());
        result = prime * result + ((closeDate == null) ? 0 : closeDate.hashCode());
        result = prime * result + ((sales == null) ? 0 : sales.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cashier other = (Cashier) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (isOpen != other.isOpen)
            return false;
        if (openDate == null) {
            if (other.openDate != null)
                return false;
        } else if (!openDate.equals(other.openDate))
            return false;
        if (closeDate == null) {
            if (other.closeDate != null)
                return false;
        } else if (!closeDate.equals(other.closeDate))
            return false;
        if (sales == null) {
            if (other.sales != null)
                return false;
        } else if (!sales.equals(other.sales))
            return false;
        return true;
    }

    
}
