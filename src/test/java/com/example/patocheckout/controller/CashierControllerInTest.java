package com.example.patocheckout.controller;

import com.example.patocheckout.entities.Cashier;
import com.example.patocheckout.service.CashierService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;

import java.util.Collections;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CashierControllerInTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CashierService cashierService;

    @BeforeEach
    public void setUp() {
        Cashier cashier = new Cashier(true, LocalDate.now());
        when(cashierService.findById(1L)).thenReturn(cashier);
        when(cashierService.findAll()).thenReturn(Arrays.asList(cashier));
        when(cashierService.findByIsOpen(true)).thenReturn(Collections.singletonList(cashier));
    }

    @Test
    public void testGetCashierById() throws Exception {
        Long cashierId = 1L;
        this.mockMvc.perform(get("/api/cashiers/{id}", cashierId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.open").value(true)); 
    }

    

}
