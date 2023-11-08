package com.example.patocheckout.service;

import java.util.Collection;

import com.example.patocheckout.entities.PaymentMethod;

public interface PaymentMethodService {

    PaymentMethod findPaymentMethodById(long id);

    PaymentMethod findPaymentMethodByName(String name);

    Collection<PaymentMethod> findAllPaymentMethods();
    
}
