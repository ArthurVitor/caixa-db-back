package com.example.patocheckout.controller;

import com.example.patocheckout.entities.Cashier;
import com.example.patocheckout.entities.Sale;
import com.example.patocheckout.service.CashierService;


import com.fasterxml.jackson.databind.ObjectMapper;

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

    @Autowired
    private ObjectMapper objectMapper;

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

   @Test
    public void testAddSale() throws Exception {
        Long cashierId = 1L;
        Sale sale = new Sale();

        this.mockMvc.perform(post("/api/cashiers/addSale/{id}", cashierId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(sale)))
                .andExpect(status().isOk());
    }

    @Test
    public void testCloseCashier() throws Exception {
        Long cashierId = 1L;

        this.mockMvc.perform(post("/api/cashiers/close/{id}", cashierId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.open").value(false));
    }

}
