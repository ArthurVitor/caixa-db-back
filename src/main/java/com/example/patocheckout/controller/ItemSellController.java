package com.example.patocheckout.controller;

import com.example.patocheckout.entities.Cashier;
import com.example.patocheckout.entities.ItemSell;
import com.example.patocheckout.service.ItemSellService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/api/itemsell")
public class ItemSellController {
    private final ItemSellService itemSellService;

    public ItemSellController(ItemSellService itemSellService) {
        this.itemSellService = itemSellService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemSell> getItemSellById(@PathVariable Long id) {
        ItemSell itemSell = itemSellService.findById(id);
        if(itemSell == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(itemSell, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Collection<ItemSell>> getAllItemSells() {
        Collection<ItemSell> itemSells = itemSellService.getAllItemSells();

        return new ResponseEntity<>(itemSells, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Cashier> deleteCashier(@PathVariable Long id) {
        ItemSell itemSell = itemSellService.findById(id);
        if(itemSell == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        itemSellService.deleteItemSell(itemSell);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<ItemSell> addItemSell(@RequestBody ItemSell itemSell) {
        if (itemSell == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        itemSellService.saveItemSell(itemSell);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
