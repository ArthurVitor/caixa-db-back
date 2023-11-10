package com.example.patocheckout.service.impl;

import com.example.patocheckout.entities.ItemSell;
import com.example.patocheckout.entities.Product;
import com.example.patocheckout.repositories.ItemSellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ItemSellServiceImpl {
    private final ItemSellRepository itemSellRepository;

    @Autowired
    public ItemSellServiceImpl(ItemSellRepository itemSellRepository) { this.itemSellRepository = itemSellRepository; }

    public Collection<ItemSell> getAllItemSells() {
        return itemSellRepository.findAll();
    }

    public ItemSell getItemSellById(Long id) {
        return itemSellRepository.findById(id).orElse(null);
    }

    public ItemSell saveItemSell(ItemSell itemSell) {
        return itemSellRepository.save(itemSell);
    }

    public void deleteItemSell(Long id) {
        itemSellRepository.deleteById(id);
    }

    public List<ItemSell> findItemSellsByProduct(Product product) {
        return itemSellRepository.findByProduct(product);
    }

}
