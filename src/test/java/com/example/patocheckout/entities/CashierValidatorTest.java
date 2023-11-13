package com.example.patocheckout.entities;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import org.junit.jupiter.api.Test;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


public class CashierValidatorTest {

    private Validator createValidator() {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.afterPropertiesSet();
        return localValidatorFactoryBean;
    }

    @Test
    void shouldNotValidateOpenDateEmpty() {
        Cashier cashier = new Cashier(true, null);

        Validator validator = createValidator();
        Set<ConstraintViolation<Cashier>> constraintViolations = validator.validate(cashier);
        assertThat(constraintViolations.size()).isEqualTo(1);
        ConstraintViolation<Cashier> violation = constraintViolations.iterator().next();
        assertThat(violation.getPropertyPath().toString()).isEqualTo("openDate");
    }
    
}
