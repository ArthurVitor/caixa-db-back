package com.example.patocheckout.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.patocheckout.service.ProductService;

@SpringBootTest
@WebAppConfiguration
public class ProductControllerTest {
    
    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void testGetProductById() throws Exception {
        long productId = 0L;

        this.mockMvc.perform(get("/api/product/" + productId).accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }

    @Test
    public void testGetProducts() throws Exception {
        this.mockMvc.perform(get("/api/products/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}
