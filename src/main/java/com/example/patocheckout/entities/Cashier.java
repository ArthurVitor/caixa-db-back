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
    private boolean isOpen = true;

    @Column(nullable = false)
    private LocalDate openDate = LocalDate.now();

    private LocalDate closeDate;


    public Cashier(boolean isOpen, LocalDate openDate) {
        this.isOpen = isOpen;
        this.openDate = openDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public void setOpenDate(LocalDate openDate) {
        if (openDate != null) {
            this.openDate = openDate;
        }
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

    @Override
    public String toString() {
        return "Cashier [id=" + id + ", isOpen=" + isOpen + ", openDate=" + openDate + ", closeDate=" + closeDate + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + (isOpen ? 1231 : 1237);
        result = prime * result + ((openDate == null) ? 0 : openDate.hashCode());
        result = prime * result + ((closeDate == null) ? 0 : closeDate.hashCode());
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
        return true;
    }

    
}
