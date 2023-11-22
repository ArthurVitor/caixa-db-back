package com.example.patocheckout;

import com.example.patocheckout.entities.PaymentMethod;
import com.example.patocheckout.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CommandLineRunnerFile implements CommandLineRunner {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @Autowired
    public CommandLineRunnerFile(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @Override
    public void run(String... args) {
        if (!paymentMethodService.isDataInitialized()) {
            paymentMethodService.savePaymentMethod(new PaymentMethod("Crédito"));
            paymentMethodService.savePaymentMethod(new PaymentMethod("Débito"));
            paymentMethodService.savePaymentMethod(new PaymentMethod("Dinheiro"));
            paymentMethodService.savePaymentMethod(new PaymentMethod("Pix"));
        }
    }
}
