package com.example.patocheckout.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patocheckout.entities.PaymentMethod;
import com.example.patocheckout.service.PaymentMethodService;
import com.example.patocheckout.service.ProductService;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/api/paymentmethod")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping
    public ResponseEntity<Collection<PaymentMethod>> getPaymentMethods() {
        return new ResponseEntity<>(paymentMethodService.findAllPaymentMethods(), HttpStatus.OK);
    }
    
}
