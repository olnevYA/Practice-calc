package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPlusEndpoint() throws Exception {
        mockMvc.perform(get("/plus/{a}/{b}", 2, 3))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }

    @Test
    public void testMinusEndpoint() throws Exception {
        mockMvc.perform(get("/minus/{a}/{b}", 5, 3))
                .andExpect(status().isOk())
                .andExpect(content().string("2"));
    }

    @Test
    public void testErrorEndpoint() throws Exception {
        mockMvc.perform(get("/error"))
                .andExpect(status().isOk())
                .andExpect(content().string("Error occurred."));
    }
}
