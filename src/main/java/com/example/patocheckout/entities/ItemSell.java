package com.example.patocheckout.entities;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "item_sell")
@Entity
public class ItemSell {

    public ItemSell() { }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = true)
    private float discount_amount;

    public long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public float getDiscountAmount() {
        return discount_amount;
    }

    @Override
    public String toString() {
        return "ItemSell{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", discount_amount=" + discount_amount +
                '}';
    }
}

