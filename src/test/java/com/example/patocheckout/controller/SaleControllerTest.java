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

import com.example.patocheckout.service.SaleService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@WebAppConfiguration
public class SaleControllerTest {

    @Autowired
    private SaleController saleController;

    @MockBean
    private SaleService saleService;

    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(saleController)
                .build();
    }

    @Test
    public void testGetSaleById() throws Exception {
        long saleId = 0L;

        this.mockMvc.perform(get("/api/sales/" + saleId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetSales() throws Exception {
        this.mockMvc.perform(get("/api/sales/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
