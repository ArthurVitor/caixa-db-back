package com.example.patocheckout.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private List<ItemSell> items;

    private Cashier cashier;

    private LocalDate saleDate = LocalDate.now();

    protected Sale() {}

    public Sale(Cashier cashier) {
        this.items = new ArrayList<>();
        this.cashier = cashier;
    }

    public void addItem(ItemSell item) {
        this.items.add(item);
    }

    public void removeItem(ItemSell itemSell) {
        this.items.remove(itemSell);
    }

    public double getSubtotal() {
        return /*this.items.stream().mapToDouble(item -> item.getSubtotal()).sum()*/ 0;
    }

    @Override
    public String toString() {
        return "Sale [cashier=" + cashier + ", id=" + id + ", items=" + items + ", saleDate=" + saleDate + "]";
    }
}
