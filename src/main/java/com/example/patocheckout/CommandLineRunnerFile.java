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
            PaymentMethod credito = new PaymentMethod();
            credito.setName("Crédito");
            paymentMethodService.savePaymentMethod(credito);

            PaymentMethod debito = new PaymentMethod();
            debito.setName("Débito");
            paymentMethodService.savePaymentMethod(debito);

            PaymentMethod dinheiro = new PaymentMethod();
            dinheiro.setName("Dinheiro");
            paymentMethodService.savePaymentMethod(dinheiro);

            PaymentMethod pix = new PaymentMethod();
            pix.setName("Pix");
            paymentMethodService.savePaymentMethod(pix);
        }
    }
}
