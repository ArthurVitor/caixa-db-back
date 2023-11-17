package com.example.patocheckout.service;

import com.example.patocheckout.entities.ItemSell;
import com.example.patocheckout.entities.Product;
import org.springframework.dao.DataAccessException;

import java.util.Collection;
import java.util.List;

public interface ItemSellService {
    Collection<ItemSell> getAllItemSells();

    ItemSell findById(Long id);

    ItemSell saveItemSell(ItemSell itemSell);

    void deleteItemSellById(Long id);

    List<ItemSell> findItemSellsByProduct(Product product);

    void deleteItemSell(ItemSell itemSell) throws DataAccessException;
}
