package com.example.patocheckout.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.example.patocheckout.entities.PaymentMethod;

import javax.xml.crypto.Data;

public interface PaymentMethodService {

    PaymentMethod findPaymentMethodById(long id) throws DataAccessException;

    PaymentMethod findPaymentMethodByName(String name) throws DataAccessException;

    Collection<PaymentMethod> findAllPaymentMethods() throws DataAccessException;

    void savePaymentMethod(PaymentMethod paymentMethod) throws DataAccessException;

    Boolean isDataInitialized() throws DataAccessException;
}
