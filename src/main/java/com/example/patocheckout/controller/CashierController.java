package com.example.patocheckout.controller;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patocheckout.entities.Cashier;
import com.example.patocheckout.service.CashierService;

@RestController
@RequestMapping("/api/cashiers")
public class CashierController {
    
    private final CashierService cashierService;

    public CashierController(CashierService cashierService) {
            this.cashierService = cashierService; 
    }

    @GetMapping
    public Collection<Cashier> getAllCashiers() {
        return cashierService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cashier> getCashierById(@PathVariable Long id) {
        Cashier cashier = cashierService.findById(id); 
        if (cashier == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }

        return new ResponseEntity<>(cashier, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cashier> saveCashier(@RequestBody Cashier cashier) {
        if(cashier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
        cashierService.save(cashier);
        return new ResponseEntity<>(HttpStatus.CREATED);  
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cashier> deleteCashier(@PathVariable Long id) {
        Cashier reqCahier = cashierService.findById(id);
        if(reqCahier == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
        cashierService.delete(reqCahier);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }
   

}
