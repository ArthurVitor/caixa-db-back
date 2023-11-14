package com.example.patocheckout.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.patocheckout.entities.Sale;
import com.example.patocheckout.service.SaleService;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

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

}
