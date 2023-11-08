package com.example.patocheckout.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.patocheckout.entities.PaymentMethod;
import com.example.patocheckout.entities.Sale;
import com.example.patocheckout.repositories.PaymentMethodRepository;
import com.example.patocheckout.repositories.SaleRepository;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    private PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodServiceImpl(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public PaymentMethod findPaymentMethodById(long id) {
        return paymentMethodRepository.findById(id).orElse(null);
    }

    @Override
    public PaymentMethod findPaymentMethodByName(String name) {
        return paymentMethodRepository.findByName(name);
    }

    @Override
    public Collection<Sale> findAllPaymentMethods() {
        return paymentMethodRepository.findAll();
    }
    
}
