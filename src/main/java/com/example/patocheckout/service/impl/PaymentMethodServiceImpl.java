package com.example.patocheckout.service.impl;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.patocheckout.entities.PaymentMethod;
import com.example.patocheckout.repositories.PaymentMethodRepository;
import com.example.patocheckout.service.PaymentMethodService;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    private PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodServiceImpl(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public PaymentMethod findPaymentMethodById(long id) throws DataAccessException {
        return paymentMethodRepository.findById(id).orElse(null);
    }

    @Override
    public PaymentMethod findPaymentMethodByName(String name) throws DataAccessException {
        return paymentMethodRepository.findByName(name);
    }

    @Override
    public Collection<PaymentMethod> findAllPaymentMethods() throws DataAccessException {
        return paymentMethodRepository.findAll();
    }
    
}
