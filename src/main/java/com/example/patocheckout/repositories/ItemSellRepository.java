package com.example.patocheckout.repositories;

import com.example.patocheckout.entities.ItemSell;
import com.example.patocheckout.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface ItemSellRepository extends JpaRepository<ItemSell, Long> {
    List<ItemSell> findByProduct(Product product);
}
