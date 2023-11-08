package com.example.patocheckout.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
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

    @OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinColumn(name = "sale_id")
    private List<ItemSell> items;

    /**
     * Relacionamento muitos para 1 com entidade PaymentMethod
     */

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    /**
     * Relacionamento muitos para 1 com entidade Cashier
     */

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cashier_id")
    private Cashier cashier;

    private LocalDate saleDate;

    protected Sale() {
    }

    public Sale(Cashier cashier) {
        this.items = new ArrayList<>();
        this.cashier = cashier;
        this.saleDate = LocalDate.now();
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

    public List<ItemSell> getItems() {
        return items;
    }

    public Cashier getCashier() {
        return cashier;
    }

    /**
     * Retorna o subtotal da vend, que é 
     * Composto pela soma do preço de cada item menos o desconto aplicado, multiplicado pela quantidade de itens
     * 
     * @return Subtotal da venda
     */

    public double getSubtotal() {
        return this.items.stream()
                .mapToDouble(item -> (item.getProduct_id().getPrice() - item.getDiscount_amount()) * item.getQuantity())
                .sum();
    }

    @Override
    public String toString() {
        return "Sale [cashier=" + cashier + ", id=" + id + ", items=" + items + ", saleDate=" + saleDate + "]";
    }
}
