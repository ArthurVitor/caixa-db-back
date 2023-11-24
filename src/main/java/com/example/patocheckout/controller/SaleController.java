package com.example.patocheckout.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.patocheckout.entities.Sale;
import com.example.patocheckout.service.CashierService;
import com.example.patocheckout.service.SaleService;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;
    @Autowired
    private CashierService cashierService;

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable Long id) {
        var sale = saleService.findSaleById(id);

        if (sale == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(sale);
    }

    @GetMapping("/")
    public ResponseEntity<Collection<Sale>> getSales(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "50") int itemsPerPage) {
        return ResponseEntity
                .ok(saleService.findAllSales(Pageable.ofSize(Math.min(itemsPerPage, 50)).withPage(page - 1)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSaleById(@PathVariable Long id) {
        var sale = saleService.findSaleById(id);

        if (sale == null)
            return ResponseEntity.notFound().build();

        var cashier = cashierService.findSaleById(id);
        
        if (cashier != null) {
            cashier.getSales().remove(sale);
            cashierService.save(cashier);
        }
        
        saleService.deleteSaleById(id);

        return ResponseEntity.noContent().build();
    }

}
