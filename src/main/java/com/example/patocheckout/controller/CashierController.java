package com.example.patocheckout.controller;

import java.math.BigDecimal;
import java.util.Collection; 

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patocheckout.entities.Cashier;
import com.example.patocheckout.entities.Sale;
import com.example.patocheckout.service.CashierService;
import com.example.patocheckout.service.SaleService;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/cashiers")
public class CashierController {
    
    private final CashierService cashierService;
    private final SaleService saleService;

    public CashierController(CashierService cashierService, SaleService saleService) {
        this.cashierService = cashierService; 
        this.saleService = saleService;
    }

    @GetMapping("all")
    public ResponseEntity<Collection<Cashier>> getAllCashiers() {
        Collection<Cashier> cashiers = cashierService.findAll(); 
        return new ResponseEntity<>(cashiers, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Cashier> getCashierById(@PathVariable Long id) {
        Cashier cashier = cashierService.findById(id); 
        if (cashier == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }

        return new ResponseEntity<>(cashier, HttpStatus.OK);
    }

    @GetMapping("isOpen/{isOpen}")
    public ResponseEntity<Collection<Cashier>> getCashierByIsOpen(@PathVariable Boolean isOpen) {
        Collection<Cashier> cashiers = cashierService.findByIsOpen(isOpen); 
        if (cashiers == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
        return new ResponseEntity<>(cashiers, HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<Cashier> saveCashier(@RequestBody Cashier cashier) {
        if(cashier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
        cashierService.save(cashier);
        return new ResponseEntity<>(HttpStatus.CREATED);  
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Cashier> deleteCashier(@PathVariable Long id) {
        Cashier cashier = cashierService.findById(id);
        if(cashier == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
        cashierService.delete(cashier);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }

    @PostMapping("addSale/{id}")
    public ResponseEntity<Cashier> addSale(@RequestBody Sale sale, @PathVariable Long id){
        Cashier cashier = cashierService.findById(id);
        if(cashier == null ){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
        if(sale == null){
              return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        } 

        cashier.getSales().add(sale); 
        cashierService.save(cashier);
        return new ResponseEntity<>(cashier, HttpStatus.OK);
    }
  
    @GetMapping("close/{id}")
    public ResponseEntity<Cashier> closeCashier(@PathVariable Long id){
        Cashier cashier = cashierService.findById(id);
         if(cashier == null ){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
        cashier.setOpen(false); 
        cashierService.save(cashier);
        return new ResponseEntity<>(cashier, HttpStatus.OK); 
    }

}
