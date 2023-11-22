package com.example.patocheckout.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Relacionamento 1 para muitos com a entidade ItemSell
     */

    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "sale_id")
    private List<ItemSell> items;

    /**
     * Relacionamento muitos para 1 com entidade PaymentMethod
     */

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @Column(nullable = false)
    private BigDecimal paidAmount;

    @Column(nullable = false)
    private BigDecimal change;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") 
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime saleDate;

    public Sale() {
        this.items = new ArrayList<>();
        this.saleDate = LocalDateTime.now();
        this.paidAmount = BigDecimal.ZERO;
        this.change = BigDecimal.ZERO;
    }

    /**
     * Retorna o id da venda
     * 
     * @return id da venda
     */

    public Long getId() {
        return id;
    }

    public void addItem(ItemSell item) {
        this.items.add(item);
    }

    public void removeItem(ItemSell itemSell) {
        this.items.remove(itemSell);
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public BigDecimal getChange() {
        return change;
    }

    public List<ItemSell> getItems() {
        return items;
    }

    /**
     * Retorna o subtotal da vend, que é
     * Composto pela soma do preço de cada item menos o desconto aplicado,
     * multiplicado pela quantidade de itens
     * 
     * @return Subtotal da venda
     */

    public BigDecimal getSubTotal() {
        return BigDecimal.valueOf(this.items.stream()
                .mapToDouble(item -> (item.getProduct().getPrice() - item.getDiscountAmount()) * item.getQuantity())
                .sum());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((items == null) ? 0 : items.hashCode());
        result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
        result = prime * result + ((paidAmount == null) ? 0 : paidAmount.hashCode());
        result = prime * result + ((change == null) ? 0 : change.hashCode());
        result = prime * result + ((saleDate == null) ? 0 : saleDate.hashCode());
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
        Sale other = (Sale) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (items == null) {
            if (other.items != null)
                return false;
        } else if (!items.equals(other.items))
            return false;
        if (paymentMethod == null) {
            if (other.paymentMethod != null)
                return false;
        } else if (!paymentMethod.equals(other.paymentMethod))
            return false;
        if (paidAmount == null) {
            if (other.paidAmount != null)
                return false;
        } else if (!paidAmount.equals(other.paidAmount))
            return false;
        if (change == null) {
            if (other.change != null)
                return false;
        } else if (!change.equals(other.change))
            return false;
        if (saleDate == null) {
            if (other.saleDate != null)
                return false;
        } else if (!saleDate.equals(other.saleDate))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Sale [id=" + id + ", items=" + items + ", saleDate=" + saleDate + "]";
    }
}
