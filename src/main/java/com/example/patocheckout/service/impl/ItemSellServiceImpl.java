package com.example.patocheckout.service.impl;

import com.example.patocheckout.entities.ItemSell;
import com.example.patocheckout.entities.Product;
import com.example.patocheckout.repositories.ItemSellRepository;
import com.example.patocheckout.service.ItemSellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ItemSellServiceImpl implements ItemSellService {

    private final ItemSellRepository itemSellRepository;

    @Autowired
    public ItemSellServiceImpl(ItemSellRepository itemSellRepository) {
        this.itemSellRepository = itemSellRepository;
    }

    @Override
    public Collection<ItemSell> getAllItemSells() {
        return itemSellRepository.findAll();
    }

    @Override
    public ItemSell findById(Long id) {
        return itemSellRepository.findById(id).orElse(null);
    }

    @Override
    public ItemSell saveItemSell(ItemSell itemSell) {
        return itemSellRepository.save(itemSell);
    }

    @Override
    public void deleteItemSellById(Long id) {
        itemSellRepository.deleteById(id);
    }

    @Override
    public List<ItemSell> findItemSellsByProduct(Product product) {
        return itemSellRepository.findByProduct(product);
    }

    @Override
    public void deleteItemSell(ItemSell itemSell) {
        itemSellRepository.delete(itemSell);
    }
}
