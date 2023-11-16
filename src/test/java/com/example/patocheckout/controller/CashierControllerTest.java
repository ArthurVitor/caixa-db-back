package com.example.patocheckout.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.patocheckout.service.CashierService;


@SpringBootTest
@WebAppConfiguration
public class CashierControllerTest {
    
    @MockBean
    private CashierService cashierService;

    private MockMvc mockMvc;

    @Autowired
    private CashierController cashierController;

    @BeforeEach
    public void init() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(cashierController)
                .build();
    }


    @Test
    public void testGetCashierById() throws Exception {
        Long cashier_id = 0L;

        this.mockMvc.perform(get("/api/cashier/" + cashier_id)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
    }
}